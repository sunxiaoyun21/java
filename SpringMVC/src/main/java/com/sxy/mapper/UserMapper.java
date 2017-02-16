package com.sxy.mapper;

import com.sxy.pojo.Roles;
import com.sxy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public interface UserMapper {
    List<User> findAll();
    void saveUser(User user);
    User findById(Integer id);
    void editUser(User user);
    void del(Integer id);
    List<Roles> findAllRole();


}
