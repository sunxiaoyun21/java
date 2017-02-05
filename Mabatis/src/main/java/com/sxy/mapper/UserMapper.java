package com.sxy.mapper;

import com.sxy.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/5.
 */
public interface UserMapper {
    @Insert("insert into `user`(username,address) values(#{username},#{address})")
    void save(User user);
    @Select("select *from user")
    List<User>  findAll();

    @Delete("delete from user where username=#{username}")
    void del(Map<String,Object> param);
}
