package com.sxy.web.user;

import com.google.common.collect.Maps;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forword("/user/login",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username=req.getParameter("username");
            String password=req.getParameter("password");

            String ip=req.getRemoteAddr();
            Map<String,Object> result= Maps.newHashMap();
            UserService userService=new UserService();
            try {
               User user= userService.login(username,password,ip);
                HttpSession session=req.getSession();
                session.setAttribute("curr",user);
                result.put("state","success");
            }catch (ServiceException e){
                result.put("state","error");
                result.put("message",e.getMessage());
            }
        readerJson(result,resp);
    }
}
