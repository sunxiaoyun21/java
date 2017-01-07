package com.sxy.test;


import com.sxy.dao.impl.UserdaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class UserCaseTest {

  @Test
    public void start(){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserdaoImpl userdao= (UserdaoImpl) applicationContext.getBean("userdao");
        userdao.save();

        UserdaoImpl userdao1=applicationContext.getBean("userdaoimpl",UserdaoImpl.class);
        userdao1.save();
    }

}
