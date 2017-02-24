package com.sxy.service;

import com.sxy.pojo.Disk;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
public interface DiskService {
    List<Disk> findDiskByFid(Integer path);

    void saveFolder(Disk disk);


    void saveFile(Integer fid, MultipartFile file);

    InputStream downloadFile(Integer id) throws FileNotFoundException;

    Disk findDiskById(Integer id);

    void delDiskById(Integer id);
}
