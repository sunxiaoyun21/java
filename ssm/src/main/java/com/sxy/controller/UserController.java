package com.sxy.controller;

import com.sxy.exception.NotFoundException;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<User> userList=userService.findAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(){
        return "user/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newUser(User user, RedirectAttributes redirectAttributes){
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/user";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id,Model model){
       User user=userService.findById(id);
       if(user==null){
           throw new NotFoundException();
       }else {
           model.addAttribute("user",user);
           return "user/edit";
       }

    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.POST)
    public String editUser(User user,RedirectAttributes redirectAttributes){
        userService.editUser(user);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/user";
    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    public String delUser(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        userService.delUser(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/user";
    }
}

