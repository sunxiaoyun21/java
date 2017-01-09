package com.sxy.service.impl;

import com.sxy.dao.Userdao;
import com.sxy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/1/7.
 */
@Service
public class UserServiceImpl implements UserService {
    //set注入
    //@Autowired
   @Resource
    private Userdao userdao;


    @Override
    public void save() {
        System.out.println("save....");
    }

    @Override
    public void update() {
        System.out.println("update......");
    }

    @Override
    public int num() {
        System.out.println("getnum.......");
        return 100;

    }
}
