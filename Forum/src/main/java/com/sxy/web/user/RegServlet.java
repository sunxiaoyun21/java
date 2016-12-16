package com.sxy.web.user;

import com.google.common.collect.Maps;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
@WebServlet("/reg")
public class RegServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forword("/user/reg",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String passsword=req.getParameter("password");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");

        Map<String,Object> result= Maps.newHashMap();
        try {
            UserService userService=new UserService();
            userService.saveUser(username,passsword,email,phone);

            result.put("state","success");
        }catch (Exception ex){
            result.put("state","error");
            result.put("message","注册失败，请稍后再试");
        }
        readerJson(result,resp);


    }
}
