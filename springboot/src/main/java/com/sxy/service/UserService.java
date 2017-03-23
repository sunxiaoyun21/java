package com.sxy.service;

import com.sxy.mapper.UserMapper;
import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
   /* public List<User> findAll() {
        return userMapper.findAll();

    }*/

    public Role findRoleByRoleId(Integer roliId) {
        return userMapper.findRoleByRoleId(roliId);

    }

    public User findByUserName(String userName) {
        return  userMapper.findByUserName(userName);
    }
}
