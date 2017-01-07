package com.sxy.service.impl;

import com.sxy.dao.Userdao;
import com.sxy.service.UserService;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/1/7.
 */
public class UserServiceImpl implements UserService {
    //set注入
    private Userdao userdao;
    private String name;
    private Integer age;
    private List<String> names;
    private Properties properties;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserdao(Userdao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void save() {
        System.out.println("save....");
    }

    @Override
    public void update() {
        System.out.println("update......");
    }
}
