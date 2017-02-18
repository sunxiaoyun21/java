package com.sxy.controller;

import com.sxy.exception.NotFoundException;
import com.sxy.pojo.Role;
import com.sxy.pojo.User;
import com.sxy.service.UserService;
import com.sxy.util.db.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String list(@RequestParam(required = false,defaultValue = "1") Integer p ,
                       @RequestParam(required = false,defaultValue = "",name = "q_name") String qName,
                       @RequestParam(required = false,defaultValue = "",name = "q_role") String qRole,
                       Model model) throws Exception{
        if(StringUtils.isNotEmpty(qName)){
            qName = new String(qName.getBytes("ISO-8859-1"),"UTF-8");
        }
        Page<User> page=userService.findUserByPageNoSearch(p,qName,qRole);//userService.findUserByPageNo(p);
        List<Role> roleList=userService.findAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("page",page);
        return "user/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(Model model){
        List<Role> roleList=userService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "user/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newUser(User user,Integer[] roleIds, RedirectAttributes redirectAttributes){
        userService.saveNewuser(user,roleIds);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return "redirect:/user";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id,Model model){
       User user=userService.findById(id);
        List<Role> roleList=userService.findAllRole();
       if(user==null){
           throw new NotFoundException();
       }else {
           model.addAttribute("roleList",roleList);
           model.addAttribute("user",user);
           return "user/edit";
       }

    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.POST)
    public String editUser(User user,Integer[] roleIds, RedirectAttributes redirectAttributes){
        userService.editUser(user,roleIds);
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

