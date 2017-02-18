package com.sxy.service;

import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import com.sxy.util.db.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface UserService {
    List<User> findAll();

    void save(User user);

    User findById(Integer id);

    void editUser(User user, Integer[] roleIds);

    void delUser(Integer id);

    List<Role> findAllRole();

    void saveNewuser(User user, Integer[] roleIds);

    Page<User> findUserByPageNo(Integer p);

    Page<User> findUserByPageNoSearch(Integer p, String qName, String qRole);
}
