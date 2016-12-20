package com.sxy.web.user;

import com.google.common.collect.Maps;
import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/18.
 */
@WebServlet("/findpassword")
public class FindpasswordServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forword("/user/findpassword",req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        String value=req.getParameter("value");

        String sessionId=req.getSession().getId();

        Map<String,Object> result= Maps.newHashMap();
        UserService userService=new UserService();
        try{
            userService.findPassword(type,value,sessionId);
            result.put("state","success");
        }catch (ServiceException e){
            result.put("state","error");
            result.put("message",e.getMessage());
        }
        readerJson(result,resp);
    }
}
