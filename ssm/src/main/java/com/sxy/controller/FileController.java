package com.sxy.controller;

import com.google.common.collect.Maps;
import com.sxy.dto.AjaxResult;
import com.sxy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/22.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload",  method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult fileUploader(MultipartFile file){

        try {
          String fileName=  fileService.uploadFile(file.getOriginalFilename(),file.getContentType(),file.getInputStream());
            Map<String,Object> map= Maps.newHashMap();
            map.put("newFileName",fileName);
            map.put("fileName",file.getOriginalFilename());
            return new AjaxResult(map);
        } catch (Exception e) {
           return new AjaxResult(AjaxResult.ERROR,e.getMessage());
        }

    }


}
