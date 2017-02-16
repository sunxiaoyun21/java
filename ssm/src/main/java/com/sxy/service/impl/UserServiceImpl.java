package com.sxy.service.impl;

import com.sxy.mapper.UserMapper;
import com.sxy.pojo.User;
import com.sxy.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
   @Value("${password.salt}")
    private String salt;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User user) {
       user.setPassword(DigestUtils.md5Hex(user.getPassword()+salt));
        userMapper.save(user);
    }
}
