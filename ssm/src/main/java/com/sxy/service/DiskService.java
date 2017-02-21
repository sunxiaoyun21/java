package com.sxy.service;

import com.sxy.pojo.Disk;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
public interface DiskService {
    List<Disk> findDiskByFid(Integer path);

    void saveFolder(Disk disk);


    void saveFile(Integer fid, MultipartFile file);
}
