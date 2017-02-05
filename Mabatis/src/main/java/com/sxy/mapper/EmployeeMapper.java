package com.sxy.mapper;

import com.sxy.pojo.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface EmployeeMapper {
    Employee findById(Integer id);
    Employee findByDepId(Integer id);
    List<Employee> findAll();


}
