package com.sxy.service.impl;

import com.sxy.mapper.RoleMapper;
import com.sxy.mapper.UserMapper;
import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import com.sxy.service.UserService;

import com.sxy.util.db.Page;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
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

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    @Transactional
    public void editUser(User user, Integer[] roleIds) {
        //删除角色
        roleMapper.delRoleByUserId(user.getId());
        //添加新角色
        if(roleIds!=null){
            for (Integer roleId:roleIds){
                Role role=roleMapper.findById(roleId);
                if(role!=null){
                    roleMapper.saveNewUserRole(user.getId(),roleId);
                }
            }
        }
        //更新用户
        if(StringUtils.isNotEmpty(user.getPassword())){
            user.setPassword(DigestUtils.md5Hex(user.getPassword()+salt ));
        }
        userMapper.editUser(user);
    }

    @Override
    @Transactional
    public void delUser(Integer id) {
        //删除用户的角色
        roleMapper.delRoleByUserId(id);
        //删除用户
        userMapper.delUser(id);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAll();
    }

    @Override
    @Transactional//事物管理
    public void saveNewuser(User user, Integer[] roleIds) {
        //1.保存用户
        userMapper.save(user);
        //2.保存用户和角色的关系
        if(roleIds !=null){
            for(Integer roleId:roleIds){
                Role role=roleMapper.findById(roleId);
                if(role !=null){
                    //创建关系表记录
                    roleMapper.saveNewUserRole(user.getId(),roleId);
                }
            }
        }

    }

    @Override
    public Page<User> findUserByPageNo(Integer p) {
       int total=userMapper.count().intValue();
        Page<User> page=new Page<>(total,p);
        List<User> userList=userMapper.findByPage(page.getStart(),page.getPageSize());
       page.setItems(userList);
        return page;
    }

    @Override
    public Page<User> findUserByPageNoSearch(Integer p, String qName, String qRole) {
        int total=userMapper.countByParam(qName,qRole).intValue();
        Page<User> page=new Page<>(total,p);
        List<User> userList=userMapper.findByPageAndParam(page.getStart(),page.getPageSize(),qName,qRole);
        page.setItems(userList);
        return page;
    }


}
