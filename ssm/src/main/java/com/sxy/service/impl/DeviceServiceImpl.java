package com.sxy.service.impl;

import com.google.common.collect.Lists;
import com.sxy.dto.DeviceRentDto;
import com.sxy.exception.ServiceException;
import com.sxy.mapper.*;
import com.sxy.pojo.*;
import com.sxy.service.DeviceService;
import com.sxy.util.SerialNumberUtil;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service
public class DeviceServiceImpl implements DeviceService{

    @Value("${upload.path}")
    private String fileSavePath;
    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceRentMapper deviceRentMapper;
    @Autowired
    private FinanceMapper financeMapper;
    @Autowired
    private DeviceRentDetailMapper deviceRentDetailMapper;
    @Autowired
    private DeviceRentDocMapper deviceRentDocMapper;

    @Override
    public void saveNewDevice(Device device) {
        //当前库存和总数相同
        device.setCurrentNum(device.getTotalNum());
        deviceMapper.saveNewDevice(device);
    }

    @Override
    public List<Device> findAll() {
        return deviceMapper.findAll();
    }

    @Override
    public List<Device> findDeviceByPage(String star, String length) {
        return deviceMapper.findDeviceByPage(star,length);
    }

    @Override
    public Long count() {
        return deviceMapper.count();
    }

    @Override
    public List<Device> findDeviceBySearchParam(Map<String, Object> searchParam) {
        return deviceMapper.findDeviceBySearchParam(searchParam);
    }

    @Override
    public void delDevice(Integer id) {
        deviceMapper.del(id);
    }

    @Override
    public Long filterCount(Map<String, Object> searchParam) {
        return deviceMapper.filterCount(searchParam);
    }

    @Override
    public Device findDeviceById(Integer id) {
        return  deviceMapper.findDeviceById(id);
    }

    @Override
    @Transactional
    public String saveRent(DeviceRentDto deviceRentDto) {
        //保存合同

        DeviceRent deviceRent=new DeviceRent();
        deviceRent.setCompanyName(deviceRentDto.getCompanyName());
        deviceRent.setLinkMan(deviceRentDto.getLinkMan());
        deviceRent.setCardNum(deviceRentDto.getCardNum());
        deviceRent.setTel(deviceRentDto.getTel());
        deviceRent.setAddress(deviceRentDto.getAddress());
        deviceRent.setFax(deviceRentDto.getFax());
        deviceRent.setCreatUser("jack");
        deviceRent.setBackDate(deviceRentDto.getBackDate());
        deviceRent.setTotalDay(deviceRentDto.getTotalDate());
        deviceRent.setPreCost(0F);
        deviceRent.setLastCost(0F);
        deviceRent.setTotalPrice(0F);
        deviceRent.setRentDate(deviceRentDto.getRentDate());
        deviceRent.setSerialNumber(SerialNumberUtil.getSerialNumber());

        deviceRentMapper.save(deviceRent);
        //保存合同详情
        List<DeviceRentDto.DeviceArrarBean> arrarBeanList=deviceRentDto.getDeviceArrar();
        List<DeviceRentDetail> detailList= Lists.newArrayList();
        float total=0F;
        for (DeviceRentDto.DeviceArrarBean arrarBean:arrarBeanList){
            //查询当前设备库存是否足够
            Device device=deviceMapper.findDeviceById(arrarBean.getId());
            if(device.getCurrentNum()<arrarBean.getNum()){
                throw new ServiceException(device.getName()+"设备不足");
            }else {
                device.setCurrentNum(device.getCurrentNum()-arrarBean.getNum());
                deviceMapper.updateCurrentNum(device);
            }
            DeviceRentDetail deviceRentDetail=new DeviceRentDetail();
            deviceRentDetail.setDeviceName(arrarBean.getName());
            deviceRentDetail.setDeviceUnit(arrarBean.getUnit());
            deviceRentDetail.setDevicePrice(arrarBean.getPrice());
            deviceRentDetail.setTotalPrice(arrarBean.getTotal());
            deviceRentDetail.setNum(arrarBean.getNum());
            deviceRentDetail.setRentId(deviceRent.getId());
            detailList.add(deviceRentDetail);

            total+=arrarBean.getTotal();
        }
        if(!detailList.isEmpty()){
            deviceRentDetailMapper.batchSave(detailList);
        }
        //计算合同总价，预付款和尾款
        total=total*deviceRent.getTotalDay();
        float preCost=total*0.3F;
        float lastCost=total-preCost;
        deviceRentMapper.updateCost(total,preCost,lastCost,deviceRent.getId());


        //保存文件
        List<DeviceRentDto.DocBean> docBeanList=deviceRentDto.getFileArray();
        List<DeviceRentDoc> docList=Lists.newArrayList();

        for (DeviceRentDto.DocBean docBean:docBeanList){
            DeviceRentDoc deviceRentDoc=new DeviceRentDoc();
            deviceRentDoc.setRentId(deviceRent.getId());
            deviceRentDoc.setNewName(docBean.getNewName());
            deviceRentDoc.setSourceName(docBean.getSourceName());
            docList.add(deviceRentDoc);
        }
        if(!detailList.isEmpty()){
            deviceRentDocMapper.batchSave(docList);
        }

        //写入财物流水
        Finance finance=new Finance();
        finance.setCeratUser("jack");
        finance.setCreateDate(DateTime.now().toString("YYYY-MM-dd"));
        finance.setRemark("预付款");
        finance.setSerialNumber(SerialNumberUtil.getSerialNumber());
        finance.setType(Finance.TYPE_IN);
        finance.setState(Finance.STATE_NEW);
        finance.setModule("设备租赁");
        finance.setMoney(preCost);
        finance.setModuleSerialNumber(deviceRent.getSerialNumber());

        financeMapper.save(finance);


        return deviceRent.getSerialNumber();
    }

    /**
     * 根据流水账号查询合同信息
     * @param serialNumber
     * @return
     */
    @Override
    public DeviceRent findDeviceBySerialNumber(String serialNumber) {
        return deviceRentMapper.findBySerialNumber(serialNumber);
    }

    /**
     * 根据租赁id查找合同详情列表
     * @param id
     * @return
     */
    @Override
    public List<DeviceRentDetail> findDeviceByRentId(Integer id) {
        return deviceRentDetailMapper.findByRentId(id);
    }

    /**
     * 根据租赁id查找合同文件详情列表
     * @param id
     * @return
     */
    @Override
    public List<DeviceRentDoc> findDeviceDocByRentId(Integer id) {
        return deviceRentDocMapper.findDeviceById(id);
    }

    /**
     * 合同附件的下载
     * @param docId
     * @return
     * @throws IOException
     */
    @Override
    public InputStream downloadFile(Integer docId) throws IOException {
        DeviceRentDoc doc=deviceRentDocMapper.findById(docId);
        if(doc==null){
            return null;
        }else {
            File file=new File(fileSavePath+"/"+doc.getNewName());
            if(file.exists()){
                return new FileInputStream(file);
            }else {
                return null;
            }
        }

    }

    @Override
    public DeviceRentDoc findDeviceRentById(Integer id) {
        return deviceRentDocMapper.findById(id);
    }

    @Override
    public DeviceRent findRentById(Integer id) {
        return deviceRentMapper.findRentById(id);
    }

    /**
     * 合同的打包下载
     * @param deviceRent
     * @param zipOutputStream
     * @throws IOException
     */

    @Override
    public void downloadZipFile(DeviceRent deviceRent, ZipOutputStream zipOutputStream) throws IOException {
        //查找合同有多少附件
        List<DeviceRentDoc> docList=findDeviceDocByRentId(deviceRent.getId());
        for (DeviceRentDoc doc:docList){
            ZipEntry entry=new ZipEntry(doc.getSourceName());
            zipOutputStream.putNextEntry(entry);

            InputStream inputStream=downloadFile(doc.getId());
            IOUtils.copy(inputStream,zipOutputStream);
            inputStream.close();
        }
        zipOutputStream.closeEntry();
        zipOutputStream.flush();
        zipOutputStream.close();

    }

    @Override
    public List<DeviceRent> findDeviceRentByMap(Map<String, Object> map) {
        return deviceRentMapper.findRentByMap(map);
    }

    @Override
    public Long findDeviceCount() {
        return deviceRentMapper.findDeviceCount();
    }

    /**
     * 修改合同状态
     * @param id
     */
    @Override
    @Transactional
    public void changRentState(Integer id) {
        //将合同修改已完成
        DeviceRent deviceRent=deviceRentMapper.findRentById(id);
        deviceRent.setState("已完成");
        deviceRentMapper.changState(deviceRent);
        //像财务模块添加尾款记录

        Finance finance=new Finance();
        finance.setCeratUser("jack");
        finance.setCreateDate(DateTime.now().toString("YYYY-MM-dd"));
        finance.setRemark("合同尾款");
        finance.setSerialNumber(SerialNumberUtil.getSerialNumber());
        finance.setType(Finance.TYPE_IN);
        finance.setState(Finance.STATE_NEW);
        finance.setModule("设备租赁");
       finance.setMoney(deviceRent.getLastCost());
        finance.setModuleSerialNumber(deviceRent.getSerialNumber());
        financeMapper.save(finance);
    }


}
