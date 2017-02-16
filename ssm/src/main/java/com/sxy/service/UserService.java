package com.sxy.service;

import com.sxy.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface UserService {
    List<User> findAll();

    void save(User user);
}
