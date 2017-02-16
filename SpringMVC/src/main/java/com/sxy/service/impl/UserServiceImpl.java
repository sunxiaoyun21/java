package com.sxy.service.impl;


import com.sxy.mapper.RoleMapper;
import com.sxy.mapper.UserMapper;
import com.sxy.pojo.Roles;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserMapper userMapper;
   @Autowired
   private RoleMapper roleMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User findById(Integer id) {

        return userMapper.findById(id);
    }

    @Override
    public void editUser(User user) {
           userMapper.editUser(user);

    }

    @Override
    public void del(Integer id) {
        userMapper.del(id);
    }

    @Override
    public List<Roles> findAllRole() {
        return userMapper.findAllRole();
    }

    @Override
    @Transactional
    public void saveNewUser(User user, Integer[] rolesId) {
       //保存用户，
        userMapper.saveUser(user);
        //保存用户和角色的关系
        addUserRole(user,rolesId);
    }

    private void addUserRole(User user, Integer[] roleids) {
        if(roleids!=null){
            for(Integer roleid:roleids){
                Roles roles=roleMapper.findById(roleid);
                if(roles!=null){
                    roleMapper.saveUserRole(user.getId(),roleid);
                }
            }
        }
    }


}
