package com.sxy.service.impl;

import com.sxy.exception.ServiceException;
import com.sxy.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

/**
 * Created by Administrator on 2017/2/22.
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${upload.path}")
    private  String path;

    @Override
    public String  uploadFile(String originalFilename, String contentType, InputStream inputStream) {
        String newFileName= UUID.randomUUID().toString();
        if(originalFilename.lastIndexOf(".")!=-1){
            newFileName+=originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        try {
            File file=new File(new File(path),newFileName);
            OutputStream outputStream=new FileOutputStream(file);
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            return newFileName;
        }catch (IOException ex){
            throw new ServiceException();
        }

    }
}
