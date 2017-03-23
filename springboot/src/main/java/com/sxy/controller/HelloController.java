package com.sxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","hello,你好");

        String name="jack";
        List<String> names= Arrays.asList("aa","bb","cc");
        model.addAttribute("name",name);
        model.addAttribute("names",names);

        return "main";
    }
}
