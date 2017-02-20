package com.sxy.mapper;

import com.sxy.pojo.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */
public interface DeviceMapper {
    void saveNewDevice(Device device);

    List<Device> findAll();

    List<Device> findDeviceByPage(@Param("star") String star, @Param("length") String length);

    Long count();

    List<Device> findDeviceBySearchParam(Map<String, Object> searchParam);

    void del(Integer id);

    Long filterCount(Map<String, Object> searchParam);

    Device findDeviceById(Integer id);


}
