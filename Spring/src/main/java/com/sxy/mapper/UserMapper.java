package com.sxy.mapper;

import com.sxy.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public interface UserMapper {

    void save(User user);
    void del(Integer id);

    @Select("select *from user where id=#{id}")
    User findById(Integer id);

    @Select("select * from user")
    List<User> findAll();
}
