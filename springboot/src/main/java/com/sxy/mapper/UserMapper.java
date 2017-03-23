package com.sxy.mapper;

import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */
@Mapper
public interface UserMapper {

   /* @Select("select*from user")
    List<User> findAll();*/

    @Select("select * from t_role where id=#{roliId}")
    Role findRoleByRoleId(Integer roliId);


    @Select("select *from t_user where username=#{username}")
    User findByUserName(String userName);
}
