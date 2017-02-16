package com.sxy.service;

import com.sxy.pojo.Roles;
import com.sxy.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public interface UserService {
    List<User> findAll();

    void saveUser(User user);

    User findById(Integer id);

    void editUser(User user);

    void del(Integer id);


    List<Roles> findAllRole();

    void saveNewUser(User user, Integer[] rolesId);
}
