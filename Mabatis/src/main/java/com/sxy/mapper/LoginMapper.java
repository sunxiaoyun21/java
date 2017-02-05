package com.sxy.mapper;

import com.sxy.pojo.Login;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface LoginMapper {
     Login findById(Integer id);
     List<Login> findAll();
     void save(Login login);
    void  update(Login login);
    void delete(Integer id);
    Login findNameAndPwd(Map<String,Object> param);
}
