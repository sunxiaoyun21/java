package com.sxy.mapper;

import com.sxy.pojo.DeviceRentDoc;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface DeviceRentDocMapper {
    void batchSave(List<DeviceRentDoc> docList);


    List<DeviceRentDoc> findDeviceById(Integer id);
}
