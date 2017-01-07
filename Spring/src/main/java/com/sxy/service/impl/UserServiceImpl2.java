package com.sxy.service.impl;

import com.sxy.dao.Userdao;
import com.sxy.service.UserService;

/**
 * Created by Administrator on 2017/1/7.
 */
public class UserServiceImpl2 implements UserService {
        //构造方法注入
    private Userdao userdao;

    public UserServiceImpl2(Userdao userdao){
        this.userdao=userdao;
    }


    @Override
    public void save() {
        System.out.println("构造方法注入");
    }

    @Override
    public void update() {
        System.out.println("构造方法注入");
    }
}
