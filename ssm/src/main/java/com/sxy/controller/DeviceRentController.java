package com.sxy.controller;

import com.sxy.dto.AjaxResult;
import com.sxy.pojo.Device;
import com.sxy.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
