package com.sxy.dao.impl;

import com.sxy.dao.Userdao;
import com.sxy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/1/7.
 */
@Service
public class UserdaoImpl implements Userdao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql="insert into user(username,address) values(?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getAddress());
    }

    @Override
    public void update(User user) {
        String sql="UPDATE user SET  username=? , address=? WHERE id=?";
        jdbcTemplate.update(sql,user.getUsername(),user.getAddress(),user.getId());
    }

    @Override
    public void del(Integer id) {
        String sql="delete from user where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public User findById(Integer id) {
       String sql="select*from user where id=?";
       return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);


    }

    @Override
    public List<User> findAll() {
      String sql="select *from user";
      return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
}
