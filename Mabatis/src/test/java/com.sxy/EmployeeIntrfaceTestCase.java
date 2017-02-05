package com.sxy;

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
public class EmployeeIntrfaceTestCase {

    @Test
    public void findById(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
        Employee e =employeeMapper.findById(1);
        Department department=e.getDepartment();
        System.out.println(e);
        System.out.println(department);

        sqlSession.close();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList=employeeMapper.findAll();
        for (Employee employee:employeeList){
            System.out.println(employee);
            Department department=employee.getDepartment();
            System.out.println(department);
        }



    }
}
