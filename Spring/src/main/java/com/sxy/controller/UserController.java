package com.sxy.controller;

import com.sxy.pojo.Account;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public  String save(){
        System.out.println("hello..mvc");
        return "/user/save";
    }

    @RequestMapping(value = "/save" ,method= RequestMethod.POST)
    public  String user(Account account){
        System.out.println(account.getUsername()+",,"+account.getPassword());
        return "redirect:/home";
    }

  /*  @RequestMapping(method = RequestMethod.GET)
    public  String show(Integer id){
        System.out.println(id);
        return "redirect:/home";
    }*/

/*    @RequestMapping(value ="/{id:\\d{3,}}", method = RequestMethod.GET)
    public  String show(@PathVariable Integer id){
        System.out.println(id);
        return "redirect:/home";
    }*/

    @RequestMapping(value ="/{id:\\d+}/{type:\\d{1,4}}",     method = RequestMethod.GET)
    public  String showUser(@PathVariable Integer id,
                            @PathVariable Integer type,
                            Model model){
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        return "/user/show";
    }
}
