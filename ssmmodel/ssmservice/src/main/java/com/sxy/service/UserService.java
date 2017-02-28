package com.sxy.service;

import com.sxy.dao.UserDao;
import com.sxy.pojo.User;

/**
 * Created by Administrator on 2017/2/28.
 */
public class UserService {

    private UserDao userDao=new UserDao();
    public void save(User user) {
            userDao.save(user);
    }
}
