package com.sxy.test;


import com.sxy.Application;
import com.sxy.dao.Userdao;
import com.sxy.dao.impl.UserdaoImpl;
import com.sxy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ContextConfiguration(classes = Application.class)
public class UserCaseTest {
    @Autowired
    private  UserService userService;
  @Test
    public void start(){
      /*  ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Userdao userdao= (Userdao) applicationContext.getBean("userdaoImpl");
        userdao.save();
*/

      userService.save();
      userService.update();
    }

    @Test
    public  void service(){

        userService.update();
        userService.save();
        userService.num();
    }

}
