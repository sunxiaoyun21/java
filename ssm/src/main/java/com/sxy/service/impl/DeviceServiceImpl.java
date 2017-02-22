package com.sxy.service.impl;

import com.google.common.collect.Lists;
import com.sxy.dto.DeviceRentDto;
import com.sxy.mapper.DeviceMapper;
import com.sxy.mapper.DeviceRentDetailMapper;
import com.sxy.mapper.DeviceRentDocMapper;
import com.sxy.mapper.DeviceRentMapper;
import com.sxy.pojo.Device;
import com.sxy.pojo.DeviceRent;
import com.sxy.pojo.DeviceRentDetail;
import com.sxy.pojo.DeviceRentDoc;
import com.sxy.service.DeviceService;
import com.sxy.util.SerialNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceRentMapper deviceRentMapper;

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
        return deviceRent.getSerialNumber();
    }


}
