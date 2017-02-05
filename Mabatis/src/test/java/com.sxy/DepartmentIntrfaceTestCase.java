package com.sxy;

import com.sxy.mapper.DepartmentMapper;
import com.sxy.mapper.EmployeeMapper;
import com.sxy.pojo.Department;
import com.sxy.pojo.Employee;
import com.sxy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public class DepartmentIntrfaceTestCase {
    @Test
    public void findById(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        Department department=departmentMapper.findById(2);
        System.out.println(department);
        List<Employee> employeeList=department.getEmployeeList();
        for(Employee employee :employeeList){
            System.out.println(employee);
        }
        sqlSession.close();
    }


    @Test
    public void findAll(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> list=departmentMapper.findAll();

        for(Department department:list){
            System.out.println(department);
            List<Employee>  employeeList=department.getEmployeeList();
            for (Employee employee:employeeList){
                System.out.println(employee);
            }
            System.out.println("-------------------------");

        }
    }
}
