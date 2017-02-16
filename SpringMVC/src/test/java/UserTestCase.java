import com.sxy.mapper.UserMapper;
import com.sxy.pojo.Roles;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext")
public class UserTestCase {
    @Autowired
    private UserService userService;
    @Test
    public  void edit(){
      User user=userService.findById(6);
        user.setUsername("aa");
        user.setAddress("www");
        userService.editUser(user);
    }

    @Test
    public void save(){

    }
}
