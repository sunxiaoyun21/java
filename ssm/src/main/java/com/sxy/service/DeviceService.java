package com.sxy.service;

import com.sxy.dto.DeviceRentDto;
import com.sxy.pojo.Device;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */

public interface DeviceService {

    void saveNewDevice(Device device);

    List<Device> findAll();

    List<Device> findDeviceByPage(String star, String length);

    Long count();

    List<Device> findDeviceBySearchParam(Map<String, Object> searchParam);

    void delDevice(Integer id);

    Long filterCount(Map<String, Object> searchParam);

    Device findDeviceById(Integer id);


    String saveRent(DeviceRentDto deviceRentDto);

}
