package com.sxy.mapper;

import com.sxy.pojo.Department;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface DepartmentMapper {
    Department findById(Integer id);
    List<Department> findAll();
    Department findByEmpId(Integer id);
}
