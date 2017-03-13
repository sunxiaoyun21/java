package com.sxy.controller;

import com.sxy.pojo.Leave;
import com.sxy.pojo.User;
import com.sxy.service.LeaveWorkFlow;
import com.sxy.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.activation.ActivationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveWorkFlow leaveWorkFlow;

    @RequestMapping(value = "/apply")
    public String processLeave(){
        return "activiti/leave/leave-apply";
    }

    @RequestMapping("/start")
    public  String startLeave(Leave leave, Model model){
        User user= ShiroUtil.getCurrentUser();
        String processDefKey="leaveProcess";
       Map<String,Object> variables=new HashMap<>();
       //模拟找到上级ID
       String upperId="18";
       variables.put("deptLeaderUserId",upperId);
       try{
           model.addAttribute("message","流程启动成功  ");
           leaveWorkFlow.processStart(leave,user,processDefKey,variables);
       }catch (Exception ex){
           model.addAttribute("message","流程启动失败");
       }

        return "activiti/leave/leave-apply";
    }
}
