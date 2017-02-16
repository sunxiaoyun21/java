package com.sxy.mapper;

import com.sxy.pojo.Roles;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface RoleMapper {
    Roles findById(Integer roleid);
    void saveUserRole(@Param("userid") Integer userid,@Param("roleid") Integer roleid);
}
