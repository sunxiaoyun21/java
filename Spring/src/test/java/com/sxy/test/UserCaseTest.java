package com.sxy.test;


import com.sxy.dao.impl.UserdaoImpl;
import com.sxy.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class UserCaseTest {

  @Test
    public void start(){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
       /* UserdaoImpl userdao= (UserdaoImpl) applicationContext.getBean("userdao");
        userdao.save();*/

      UserService userService= (UserService) applicationContext.getBean("userservice");
      userService.save();
      userService.update();
    }

    @Test
    public  void service(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userservice2");
        userService.update();
    }

}
