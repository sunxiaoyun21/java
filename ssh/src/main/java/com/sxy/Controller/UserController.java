package com.sxy.Controller;

import com.sxy.pojo.User;
import com.sxy.service.UserService;
import com.sxy.util.Page;
import com.sxy.util.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Model model,
                       @RequestParam(required = false,defaultValue = "1" ,name="p")Integer pageNo,
                       HttpServletRequest request){
      List<QueryParam> queryParamList= QueryParam.builderQueryparambyRequest(request);
       // Page<User> page=userService.findByQueryParam(pageNo,queryParamList);

        //List<User> users=userService.findAll();
        List<User> users=userService.findByQueryParam(queryParamList);
        model.addAttribute("items",users);
        return "user";
    }

    @GetMapping("/{id:\\d+}")
    public String user(@PathVariable Integer id,Model model){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        return "role";
    }


}
