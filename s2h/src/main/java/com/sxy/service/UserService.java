package com.sxy.service;

import com.sxy.dao.UserDao;
import com.sxy.pojo.User;
import com.sxy.util.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

   @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();

    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    public void del(Integer id) {
        userDao.delById(id);

    }

    public User findById(Integer id) {
        return userDao.findById(id);



    }

    public List<User> findByQueryParam(List<QueryParam> paramList) {
       return userDao.findByQueryParam(paramList);
    }
}
