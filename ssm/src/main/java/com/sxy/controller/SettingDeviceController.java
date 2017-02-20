package com.sxy.controller;

import com.google.common.collect.Maps;
import com.sxy.pojo.Device;
import com.sxy.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统中的设备管理界面控制器
 */
@Controller
@RequestMapping("/setting/device")
public class SettingDeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        return "setting/device/list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newDevice(){
        return "setting/device/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public  String newDevice(Device device, RedirectAttributes redirectAttributes){
       deviceService.saveNewDevice(device);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/setting/device";
    }

    @RequestMapping(value = "/load",method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> load(HttpServletRequest request){
       String draw=request.getParameter("draw");
       String star=request.getParameter("start");
       String length=request.getParameter("length");
       String orderIndex=request.getParameter("order[0][column]");
       String orderType=request.getParameter("order[0][dir]");
       String orderName=request.getParameter("columns["+orderIndex+"][name]");
       String deviceName=request.getParameter("deviceName");

       Map<String,Object> searchParam=Maps.newHashMap();
       searchParam.put("star",star);
       searchParam.put("length",length);
       searchParam.put("orderType",orderType);
       searchParam.put("orderName",orderName);
       searchParam.put("deviceName",deviceName);

       List<Device> deviceList=deviceService.findDeviceBySearchParam(searchParam);
       Long count=deviceService.count();
       Long filteredCount=deviceService.filterCount(searchParam);
       Map<String,Object> resultMap= Maps.newHashMap();
       resultMap.put("draw",draw);
       resultMap.put("recordsTotal",count);//总记录数
       resultMap.put( "recordsFiltered",filteredCount);//过滤后的总记录数
       resultMap.put("data",deviceList);
       return resultMap;
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    @ResponseBody
    public String delDevice(@PathVariable Integer id){
        deviceService.delDevice(id);
        return "success";
    }
}


