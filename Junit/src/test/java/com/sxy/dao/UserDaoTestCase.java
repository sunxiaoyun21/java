package com.sxy.dao;

import com.sxy.entity.User;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class UserDaoTestCase {

    Userdao userdao;

    @Before
    public void  before(){
        userdao=new Userdao();
    }

    @Test
    public void testSave(){
        User user=new User();
        user.setName("zhangsa");
        user.setAge(5);
        user.setTel(23456);
        user.setAddress("chain");

        userdao.save(user);
    }

    @Test
    public void testFindById(){
        User user=userdao.findById(11);
       assertNotNull(user);
    }

    @Test
    public  void testFindAll(){
        List<User> userList=userdao.findAll();
        assertEquals(5,userList.size());

    }

    @Test
    public  void  del(){
        userdao.del(3);
    }
}
