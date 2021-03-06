package com.sxy.controller;

import com.google.common.collect.Maps;
import com.sxy.dto.AjaxResult;
import com.sxy.dto.DataTablesResult;
import com.sxy.dto.DeviceRentDto;
import com.sxy.exception.NotFoundException;
import com.sxy.exception.ServiceException;
import com.sxy.pojo.Device;
import com.sxy.pojo.DeviceRent;
import com.sxy.pojo.DeviceRentDetail;
import com.sxy.pojo.DeviceRentDoc;
import com.sxy.service.DeviceService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("/device/rent")
public class DeviceRentController {

    @Autowired
    private DeviceService deviceService;



    /**
     * 新建租赁合同
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newRent(Model model){
        List<Device> deviceList=deviceService.findAll();
        model.addAttribute("deviceList",deviceList);

        return "device/rent/new";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(){
        return "device/rent/list";
    }

    /**
     * 合同列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public  DataTablesResult  load(HttpServletRequest request){
        String draw=request.getParameter("draw");
        String start=request.getParameter("start");
        String length=request.getParameter("length");

        Map<String,Object> map= Maps.newHashMap();
        map.put("start",start);
        map.put("length",length);

        List<DeviceRent> deviceRentList=deviceService.findDeviceRentByMap(map);
        Long count=deviceService.findDeviceCount();
        return  new DataTablesResult(draw,count,count,deviceRentList);
    }
    /**
     * 保存合同
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult saveRent(@RequestBody DeviceRentDto deviceRentDto){
       try{
           String serialNumber= deviceService.saveRent(deviceRentDto);
           AjaxResult result=new AjaxResult();
           result.setData(serialNumber);
           result.setStatus(AjaxResult.SUCCESS);
           return result;
       }catch (ServiceException ex){
           return new AjaxResult(AjaxResult.ERROR,ex.getMessage());
       }

    }
    /**
     * 根据流水号显示合同详情
     */
    @RequestMapping(value ="{serialNumber:\\d+}",  method = RequestMethod.GET)
    public  String showDeviceRent(@PathVariable String serialNumber, Model model){
        //查询合同对象
        DeviceRent deviceRent=deviceService.findDeviceBySerialNumber(serialNumber);

        if(deviceService==null){
            throw new NotFoundException();
        }else {
            //查询合同详情列表
               List<DeviceRentDetail> detailList=deviceService.findDeviceByRentId(deviceRent.getId());
            //查询合同文件列表
            List<DeviceRentDoc> docList=deviceService.findDeviceDocByRentId(deviceRent.getId());
            model.addAttribute("rent",deviceRent);
            model.addAttribute("detailList",detailList);
            model.addAttribute("docList",docList);
        }

        return "device/rent/show";

    }

    /**
     * 将合同修改为已完成
     * @param id
     * @return
     */
    @RequestMapping(value = "/state/change",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult stateChang(Integer id){
        deviceService.changRentState(id);
        return new AjaxResult(AjaxResult.SUCCESS);
    }

    /**
     * 根据设备ID查找设备信息
     * @param id
     * @return
     */

    @RequestMapping(value = "/device.json",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult deviceJson(Integer id){
     Device device= deviceService.findDeviceById(id);
     if(device==null){
         return new AjaxResult(AjaxResult.ERROR,"设备不存在");
     }
        return new AjaxResult(device);
    }

    /**
     * 使用mvc方式下载
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = ("/doc"),method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadDoc(Integer id) throws IOException {
        InputStream inputStream=deviceService.downloadFile(id);

        if(inputStream==null){
            throw new NotFoundException();
        }else {
            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //更改下载文件名的名字
            DeviceRentDoc doc=deviceService.findDeviceRentById(id);
            String fileName=doc.getSourceName();
            fileName=new String(fileName.getBytes("UTF-8"),"ISO8859-1");
          headers.setContentDispositionFormData("attachment",fileName);
            return new ResponseEntity<>(new InputStreamResource(inputStream),headers, HttpStatus.OK);
        }

    }


    /**
     * 打包下载
     */
    @RequestMapping(value = "/doc/zip",method = RequestMethod.GET)
    public void downloadZipFile(Integer id,HttpServletResponse response) throws IOException {
        DeviceRent deviceRent=deviceService.findRentById(id);

        if(deviceRent==null){
            throw new NotFoundException();
        }else {
            //将文件下载标记为二进制
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            //更改下载文件名的名字
            DeviceRentDoc doc=deviceService.findDeviceRentById(id);
            String fileName=deviceRent.getCompanyName()+".zip";
            fileName=new String(fileName.getBytes("UTF-8"),"ISO8859-1");
            response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
           OutputStream outputStream=response.getOutputStream();
            ZipOutputStream zipOutputStream=new ZipOutputStream(outputStream);
            deviceService.downloadZipFile(deviceRent,zipOutputStream);
        }
    }

    /**
     * 原始的下载合同
     */

  /*  @RequestMapping(value = ("/doc"),method = RequestMethod.GET)
    public void downloadDoc(Integer id, HttpServletResponse response) throws IOException {
        InputStream inputStream=deviceService.downloadFile(id);

        if(inputStream==null){
            throw new NotFoundException();
        }else {
            DeviceRentDoc doc=deviceService.findDeviceRentById(id);
            //将文件下载标记为二进制
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            //更改下载文件名的名字
            String fileName=doc.getSourceName();
            fileName=new String(fileName.getBytes("UTF-8"),"ISO8859-1");
            response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
            OutputStream outputStream=response.getOutputStream();
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }
*/

}
