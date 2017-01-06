package com.sxy;

import com.sxy.mapper.UserMapper;
import com.sxy.pojo.User;
import com.sxy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2017/2/5.
 */
public class UserInterfaceTestCase {
    private  SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void stat(){
         sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
        userMapper=sqlSession.getMapper(UserMapper.class);
    }
    @After
    public  void after(){
        sqlSession.close();
    }

    @Test
    public void save(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("jack");
        user.setAddress("usa");
        userMapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAll(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> users=userMapper.findAll();

        for (User user:users){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void del(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","tom");
        userMapper.del(map);
    }

    @Test
    public void findByName(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","jack");



       User user= userMapper.findByName(map);
        System.out.println(user);
    }

    @Test
    public void saveAll(){
       List<User> users= new ArrayList<>();
       users.add(new User("tom","上海"));
       users.add(new User("rose","北京"));
       users.add(new User("lisi","中国"));
       userMapper.saveAll(users);





    }
}
