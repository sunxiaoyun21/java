package com.sxy.controller;

import com.sxy.dto.AjaxResult;
import com.sxy.exception.ServiceException;
import com.sxy.pojo.Disk;
import com.sxy.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/pan")
public class PanController {

   @Autowired
    private DiskService diskService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(required = false,defaultValue = "0")Integer path, Model model){
        List<Disk> diskList=diskService.findDiskByFid(path);
        model.addAttribute("diskList",diskList);
        model.addAttribute("fid",path);
        return "pan/list";
    }

    /**
     * 新建文件夹
     * @param disk
     * @return
     */
    @RequestMapping(value ="/folder/new"  ,method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult saveFolder(Disk disk){
        diskService.saveFolder(disk);
        return new AjaxResult(AjaxResult.SUCCESS);
    }

    /**
     * 上传文件
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public  AjaxResult saveFile(Integer fid ,MultipartFile file){
       try {
           diskService.saveFile(fid,file);
           return new AjaxResult(AjaxResult.SUCCESS);
       }catch (ServiceException ex){
           return new AjaxResult(AjaxResult.ERROR,ex.getMessage());
       }

    }
}
