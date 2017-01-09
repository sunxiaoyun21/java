package com.sxy.dao.impl;

import com.sxy.dao.Userdao;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/7.
 */
@Service
public class UserdaoImpl implements Userdao {
    public UserdaoImpl(){
        System.out.println("you have me");
    }

    @Override
    public void save() {
        System.out.println("I have a pen ,I have apple");
    }
}
