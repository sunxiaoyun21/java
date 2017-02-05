package com.sxy.mapper;

import com.sxy.pojo.Login;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
public interface LoginMapper {
    public Login findById(Integer id);
    public List<Login> findAll();
    public void save(Login login);
    public  void  update(Login login);
    public  void delete(Integer id);
}
