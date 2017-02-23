package com.sxy.mapper;

import com.sxy.pojo.DeviceRent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface DeviceRentMapper {
    void save(DeviceRent deviceRent);

    void updateCost(@Param("total") float total,@Param("preCost") float preCost,@Param("lastCost") float lastCost,@Param("id") Integer id);

    DeviceRent findBySerialNumber(String serialNumber);

    DeviceRent findRentById(Integer id);

    List<DeviceRent> findRentByMap(Map<String, Object> map);

    Long findDeviceCount();


    void changState(DeviceRent deviceRent);
}
