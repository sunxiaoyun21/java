package com.sxy.controller;

import com.sxy.exception.NotFondException;
import com.sxy.pojo.Roles;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model){
        List<User> userList=userService.findAll();
        model.addAttribute("userList",userList);
        return "user/list";
    }
    @RequestMapping(value ="/new",method = RequestMethod.GET)
    public String saveUser(Model model){
        List<Roles> rolesList=userService.findAllRole();
        model.addAttribute("roleList",rolesList);
        return "user/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveUser(User user ,Integer[] rolesId,  RedirectAttributes redirectAttributes ){
       redirectAttributes.addFlashAttribute("message","添加成功");
        userService.saveNewUser(user,rolesId);
        return "redirect:/user";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.GET)
    public  String editUser(@PathVariable Integer id ,Model model){
        User user=userService.findById(id);
        if(user==null){
            throw  new NotFondException();
        }else {

            model.addAttribute("users",user);
            return "user/edit";
        }

    }

    @RequestMapping(value ="/edit/{id:\\d+}",method = RequestMethod.POST)
    public String editUser(User user ,RedirectAttributes redirectAttributes){
        userService.editUser(user);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/user";
    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    public  String delUser(@PathVariable Integer id ,RedirectAttributes redirectAttributes){
       userService.del(id);
       redirectAttributes.addFlashAttribute("message","删除成功");
       return "redirect:/user";


    }

}
