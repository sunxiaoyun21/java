package com.sxy.mapper;

import com.sxy.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */
public interface RoleMapper {
    List<Role> findAll();
    Role findById(Integer roleId);

    void saveNewUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    void delRoleByUserId(Integer id);
    List<Role> findByUserId(Integer id);
}
