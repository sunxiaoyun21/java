package com.sxy.controller;

import com.sxy.pojo.Leave;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/10.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @RequestMapping(value = "/apply")
    public String processLeave(){
        return "activiti/leave/leave-apply";
    }


}
