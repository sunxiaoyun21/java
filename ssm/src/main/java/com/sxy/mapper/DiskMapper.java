package com.sxy.mapper;

import com.sxy.pojo.Disk;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
public interface DiskMapper {
    List<Disk> findDiskByFid(Integer fid);

    void saveFolder(Disk disk);
}
