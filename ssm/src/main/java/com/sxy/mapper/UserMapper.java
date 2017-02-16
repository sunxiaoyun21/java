package com.sxy.mapper;

import com.sxy.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface UserMapper {

    List<User> findAll();
    void save(User user);
}
