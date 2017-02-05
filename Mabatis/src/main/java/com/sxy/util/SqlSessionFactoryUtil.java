package com.sxy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2017/1/4.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory=buildSessionFactory();

    private static SqlSessionFactory buildSessionFactory() {

        Reader reader= null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
             return  new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw  new RuntimeException("读取xml文件异常",e);
        }

    }

   public static SqlSessionFactory getSessionFactory(){
        return sqlSessionFactory ;
    }
    public  static  SqlSession getSqlSession(){
       return  getSessionFactory().openSession();
    }
    public static  SqlSession getSqlSession(Boolean isCommit){
        return  getSessionFactory().openSession(isCommit);//获取一个自动提交事物的session;
    }
}
