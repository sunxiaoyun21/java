package com.sxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String read(){
        System.out.println("success");
        return "/user/home";
    }
}
