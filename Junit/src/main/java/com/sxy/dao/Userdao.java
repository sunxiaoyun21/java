package com.sxy.dao;

import com.sxy.entity.User;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Userdao {

    public void save(User user){
        String sql="INSERT INTO user( name, age, tel, adress) VALUES (?,?,?,?)";
        Dbhelp.update(sql,user.getName(),user.getAge(),user.getTel(),user.getAddress());
    }
    public User findById(Integer id){
        String sql="SELECT *FROM user WHERE id=?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),id);

    }
    public List<User> findAll(){
        String sql="SELECT *FROM user";
        return  Dbhelp.query(sql,new BeanListHandler<User>(User.class));
    }

    public void del(int id) {
        String sql="DELETE FROM  user WHERE id=?";
        Dbhelp.update(sql,id);

    }
}
