package com.sxy.dao;

import com.sxy.pojo.User;

/**
 * Created by Administrator on 2017/2/28.
 */
public class UserDao {
    public void save(User user) {
        System.out.println(user.getName()+"->"+user.getAge());
    }
}
