package com.sxy.controller;

import com.sxy.dto.AjaxResult;
import com.sxy.exception.NotFoundException;
import com.sxy.exception.ServiceException;
import com.sxy.pojo.Disk;
import com.sxy.service.DiskService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    /**
     * 下载文件
     * @param id
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public  void downLoadFile(Integer id, HttpServletResponse response) throws IOException {

        InputStream inputStream=diskService.downloadFile(id);
        if(inputStream==null){
            throw new NotFoundException();
        }else {
            Disk disk=diskService.findDiskById(id);
            OutputStream outputStream=response.getOutputStream();
            //将文件下载标记为二进制
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            String fileName=disk.getSourceName();
            fileName=new String(fileName.getBytes("UTF-8"),"ISO8859-1");
            response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }


    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult delDisk(@PathVariable Integer id){
        diskService.delDiskById(id);
        return new AjaxResult(AjaxResult.SUCCESS);

    }

}
