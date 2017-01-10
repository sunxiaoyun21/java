package com.sxy;

import com.sxy.mapper.UserMapper;
import com.sxy.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserMapperCaseTset {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void save(){
        User user=new User("rose","北京");
        userMapper.save(user);
    }

    @Test
    public  void del(){
     userMapper.del(9);
    }

    @Test
    public  void findById(){
        User user=userMapper.findById(6);
        System.out.println(user);
    }

    @Test
    public void  findAll(){
        List<User> users=userMapper.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }
}
