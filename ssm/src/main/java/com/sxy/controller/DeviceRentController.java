package com.sxy.controller;

import com.sxy.dto.AjaxResult;
import com.sxy.dto.DeviceRentDto;
import com.sxy.exception.NotFoundException;
import com.sxy.pojo.Device;
import com.sxy.pojo.DeviceRent;
import com.sxy.pojo.DeviceRentDetail;
import com.sxy.pojo.DeviceRentDoc;
import com.sxy.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
@Controller
@RequestMapping("/device/rent")
public class DeviceRentController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(){
        return "device/rent/list";
    }

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

    /**
     * 保存合同
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult saveRent(@RequestBody DeviceRentDto deviceRentDto){
       String serialNumber= deviceService.saveRent(deviceRentDto);
       AjaxResult result=new AjaxResult();
       result.setData(serialNumber);
       result.setStatus(AjaxResult.SUCCESS);
        return result;
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


}
