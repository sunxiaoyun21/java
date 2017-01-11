package com.sxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String read(){
        System.out.println("success");
        return "redirect:/home";
    }
}
