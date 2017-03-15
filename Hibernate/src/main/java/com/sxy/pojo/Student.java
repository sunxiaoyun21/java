package com.sxy.pojo;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Student {

    private Integer id;
    private String name;
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
