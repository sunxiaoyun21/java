package com.sxy.controller;

import com.sxy.exception.NotFindexception;
import com.sxy.pojo.Account;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String showUser(Model model){
        Account account=new Account();
        account.setUsername("tom");
        account.setPassword("123456");

        Account account1=new Account();
        account1.setUsername("jack");
        account1.setPassword("123123");

        List<Account> accountList= Arrays.asList(account,account1);
        model.addAttribute("accountList",accountList);
        return "/user/home";
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save(){
        return "/user/save";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  String newUser(Account account ,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/{id:\\d+}/{username}",method = RequestMethod.GET,
                                     produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String show(@PathVariable int id,@PathVariable String username){
        if("tom".equals(username)){
            return "可用";
        }else {
            return "不可用";
        }
    }
    @RequestMapping(value = "/{id:\\d+}",method =RequestMethod.GET)
    @ResponseBody
    public  Account findById(@PathVariable int id){
        Account account=new Account();
        account.setUsername("tom");
        account.setPassword("123456");

        return account;

}

@RequestMapping("/u-{id:\\d+}")
   public String num(@PathVariable int id){
        if(id==10){
            throw  new NotFindexception();
        }
        return "/user/home";
   }





  /*  @RequestMapping(value = "/save",method = RequestMethod.GET)
    public  String save(){
        System.out.println("hello..mvc");
        return "/user/save";
    }
*/
   /* @RequestMapping(value = "/save" ,method= RequestMethod.POST)
    public  String user(Account account){
        System.out.println(account.getUsername()+",,"+account.getPassword());
        return "redirect:/home";
    }*/

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

  /*  @RequestMapping(value ="/{id:\\d+}/{type:\\d{1,4}}",     method = RequestMethod.GET)
    public  String showUser(@PathVariable Integer id,
                            @PathVariable Integer type,
                            Model model){
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        return "/user/show";
    }*/
}
