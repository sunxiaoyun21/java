package com.sxy;

import com.sxy.mapper.UserMapper;
import com.sxy.pojo.User;
import com.sxy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/5.
 */
public class UserInterfaceTestCase {

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
}
