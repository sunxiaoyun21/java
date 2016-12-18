package com.sxy.dao;

import com.sxy.entity.User;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Administrator on 2016/12/16.
 */
public class UserDao {

    public  void save(User user){
        String sql="INSERT INTO user(username, password, email, phone, status,  avatar) VALUES (?,?,?,?,?,?)";
        Dbhelp.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getStatus(),user.getAvatar());
    }

    public User findUser(String username) {
        String sql="SELECT *FROM user WHERE username=?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),username);

    }

    public User findEmail(String email) {
        String sql="SELECT *FROM user WHERE email=?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),email);
    }

    public void update(User user) {
        String sql="update user set password=?,email=?,phone=?,status=?,avatar=? where id = ?";
        Dbhelp.update(sql,user.getPassword(),user.getEmail(),user.getPhone(),user.getStatus(),user.getAvatar(),user.getId() );
    }

    public User findById(String id) {
        String sql="select*from user where id=?";
       return Dbhelp.query(sql,new BeanHandler<>(User.class),id);
    }
}
