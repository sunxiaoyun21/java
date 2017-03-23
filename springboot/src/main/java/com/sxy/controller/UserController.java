package com.sxy.controller;

import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */
@Controller("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String list(Model model){

        //List<User> userList=userService.findAll();
        //model.addAttribute("userList",userList);
        return "main";
    }


}
