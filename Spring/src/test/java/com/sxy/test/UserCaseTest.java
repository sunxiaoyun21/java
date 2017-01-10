package com.sxy.test;


import com.sxy.Application;
import com.sxy.dao.Userdao;
import com.sxy.dao.impl.UserdaoImpl;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration(classes = Application.class)
public class UserCaseTest {
   @Autowired
    private Userdao userdao;

   @Test
   public  void save(){
       User user=new User("jack" ,"焦作" );
       userdao.save(user);

   }

   @Test
   public  void update(){
     User user=userdao.findById(6);
     user.setUsername("tom");
     user.setAddress("上海");
     userdao.update(user);
   }
    @Test
   public  void del(){
       userdao.del(10);
   }

   @Test
   public  void findAll(){
       List<User> userList=userdao.findAll();
       for(User user:userList){
           System.out.println(user);
       }
   }


















    @Test
    public void start(){
      /*  ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Userdao userdao= (Userdao) applicationContext.getBean("userdaoImpl");
        userdao.save();
*/

    /*  userService.save();
      userService.update();*/
    }

    @Test
    public  void service(){

      /*  userService.update();
        userService.save();
        userService.num();*/
    }

}
