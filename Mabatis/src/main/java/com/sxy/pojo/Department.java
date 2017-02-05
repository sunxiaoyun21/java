package com.sxy.pojo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public class Department {
    private Integer id;
    private  String depname;
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depname='" + depname + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
