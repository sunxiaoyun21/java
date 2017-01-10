package com.sxy.dao;

import com.sxy.pojo.User;

import java.util.List;


/**
 * Created by Administrator on 2017/1/7.
 */

public interface Userdao {
    void  save(User user);
    void update(User user);
    void del(Integer id);
    User findById(Integer id);
    List<User> findAll();


}
