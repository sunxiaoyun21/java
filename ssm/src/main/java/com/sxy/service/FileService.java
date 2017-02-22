package com.sxy.service;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface FileService {
    String uploadFile(String originalFilename, String contentType, InputStream inputStream);


}
