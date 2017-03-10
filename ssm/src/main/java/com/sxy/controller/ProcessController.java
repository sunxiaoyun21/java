package com.sxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/10.
 */
@Controller
@RequestMapping("/process")
public class ProcessController {

    @RequestMapping
    public String processList(){
        return "activiti/process/processList";
    }


}
