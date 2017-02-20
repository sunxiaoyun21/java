package com.sxy.service.impl;

import com.sxy.mapper.DeviceMapper;
import com.sxy.pojo.Device;
import com.sxy.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public void saveNewDevice(Device device) {
        //当前库存和总数相同
        device.setCurrentNum(device.getTotalNum());
        deviceMapper.saveNewDevice(device);
    }

    @Override
    public List<Device> findAll() {
        return deviceMapper.findAll();
    }

    @Override
    public List<Device> findDeviceByPage(String star, String length) {
        return deviceMapper.findDeviceByPage(star,length);
    }

    @Override
    public Long count() {
        return deviceMapper.count();
    }

    @Override
    public List<Device> findDeviceBySearchParam(Map<String, Object> searchParam) {
        return deviceMapper.findDeviceBySearchParam(searchParam);
    }

    @Override
    public void delDevice(Integer id) {
        deviceMapper.del(id);
    }

    @Override
    public Long filterCount(Map<String, Object> searchParam) {
        return deviceMapper.filterCount(searchParam);
    }
}
