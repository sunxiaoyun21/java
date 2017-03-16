package com.sxy.Controller;

import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String list(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("userList",users);
        return "user";
    }

    @GetMapping("/{id:\\d+}")
    public String user(@PathVariable Integer id,Model model){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        return "role";
    }
}
