package com.sxy;

import com.sxy.mapper.LoginMapper;
import com.sxy.pojo.Login;
import com.sxy.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Administrator on 2017/1/4.
 */
public class MyBatisInterfaceTestCase {

    @Test
    public  void  findById(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        LoginMapper loginMapper=sqlSession.getMapper(LoginMapper.class);
        Login login=loginMapper.findById(1);
        System.out.println(login);
        sqlSession.close();
    }
    @Test
    public void save(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
        LoginMapper loginMapper=sqlSession.getMapper(LoginMapper.class);
        Login login=new Login();
        login.setUsername("sql");
        login.setPassword("123");
        loginMapper.save(login);
        System.out.println(login.getId());
        sqlSession.close();

    }
}
