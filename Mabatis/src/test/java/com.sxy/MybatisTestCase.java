package com.sxy;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sxy.pojo.Login;
import com.sxy.util.SqlSessionFactoryUtil;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.List;


/**
 * Created by Administrator on 2017/1/4.
 */

public class MybatisTestCase {

   /* public void readXml(){
        try {
            //读取配置文件
            Reader reader= Resources.getResourceAsReader("mybatis.xml");
            //构建sqlsessionFactory对象
            SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //创建sqlsession对象
            SqlSession sqlSession=sessionFactory.openSession();

            //释放资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    @Test
    public  void findById(){
        SqlSession sqlSession= SqlSessionFactoryUtil.getSqlSession();
        Login login=sqlSession.selectOne("com.sxy.mapper.LoginMapper.findById",1);
        System.out.println(login);
        sqlSession.close();
    }

   @Test
    public  void  save(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
        Login login=new Login();
        login.setUsername("aa");
        login.setPassword("123");
        sqlSession.insert("com.sxy.mapper.LoginMapper.save",login);
        sqlSession.close();

    }

    @Test
    public void update(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
       Login login=sqlSession.selectOne("com.sxy.mapper.LoginMapper.findById",4);
       login.setUsername("zhang");
       sqlSession.update("com.sxy.mapper.LoginMapper.update",login);

       sqlSession.close();
    }

    @Test
    public  void delete(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession(true);
        sqlSession.delete("com.sxy.mapper.LoginMapper.delete",3);
        sqlSession.close();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession=SqlSessionFactoryUtil.getSqlSession();
        List<Login> loginList=sqlSession.selectList("com.sxy.mapper.LoginMapper.findAll");
        for(Login login:loginList){
            System.out.println(login);
        }
    }
}
