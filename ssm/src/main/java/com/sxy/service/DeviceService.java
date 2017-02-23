package com.sxy.service;

import com.sxy.dto.DeviceRentDto;
import com.sxy.pojo.Device;
import com.sxy.pojo.DeviceRent;
import com.sxy.pojo.DeviceRentDetail;
import com.sxy.pojo.DeviceRentDoc;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

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

    DeviceRent findDeviceBySerialNumber(String serialNumber);

    List<DeviceRentDetail> findDeviceByRentId(Integer id);

    List<DeviceRentDoc> findDeviceDocByRentId(Integer id);

    InputStream downloadFile(Integer id) throws IOException;

    DeviceRentDoc findDeviceRentById(Integer id);

    DeviceRent findRentById(Integer id);

    void downloadZipFile(DeviceRent deviceRent, ZipOutputStream zipOutputStream) throws IOException;

}
