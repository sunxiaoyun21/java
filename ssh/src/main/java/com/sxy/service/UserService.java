package com.sxy.service;

import com.sxy.dao.UserDao;
import com.sxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    @Transactional
    public void delete(User user){
        userDao.delete(user);
    }
    @Transactional(readOnly = true)
    public User findById(Integer id){
      return   userDao.findById(id);
    }
    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userDao.findAll();
    }
}
