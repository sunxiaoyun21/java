package com.sxy.mapper;

import com.sxy.pojo.DeviceRentDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface DeviceRentDetailMapper {
    void batchSave(List<DeviceRentDetail> detailList);

}
