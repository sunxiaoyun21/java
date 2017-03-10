package com.sxy.mapper;

import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public interface UserMapper {

    List<User> findAll();
    void save(User user);
    User findById(Integer id);
    void editUser(User user);
    void delUser(Integer id);

    Long count();

    List<User> findByPage(@Param("start") int start,@Param("pageSize") int pageSize);

    Number countByParam(@Param("qName") String qName,@Param("qRole") String qRole);

    List<User> findByPageAndParam(@Param("start") int start,@Param("pageSize") int pageSize,
                                  @Param("qName") String qName,@Param("qRole") String qRole);

    User findUserByName(String userName);

}
