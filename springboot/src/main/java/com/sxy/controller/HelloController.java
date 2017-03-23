package com.sxy.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Controller
public class HelloController {

    @GetMapping("/login")
    public String hello(){
        return "login";
    }

    @PostMapping ("/login")
    public String hello(String username,String password){
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));


            return "redirect:/home";
        }catch (LockedAccountException ex){
            ex.printStackTrace();
            return "redirect:/login";
        }

    }
}
