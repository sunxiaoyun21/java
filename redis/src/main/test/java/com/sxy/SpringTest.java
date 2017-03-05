package com.sxy;

import com.sxy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/3/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class SpringTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveTest(){
        userService.saveRedis();
    }

    @Test
    public  void getTest(){
        System.out.println(userService.getFromRedis());
    }
}
