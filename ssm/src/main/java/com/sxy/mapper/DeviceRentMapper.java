package com.sxy.mapper;

import com.sxy.pojo.DeviceRent;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface DeviceRentMapper {
    void save(DeviceRent deviceRent);

    void updateCost(@Param("total") float total,@Param("preCost") float preCost,@Param("lastCost") float lastCost,@Param("id") Integer id);

    DeviceRent findBySerialNumber(String serialNumber);
}
