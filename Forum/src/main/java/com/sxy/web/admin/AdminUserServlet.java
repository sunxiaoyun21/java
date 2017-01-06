package com.sxy.web.admin;

import com.google.common.collect.Maps;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.util.Page;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/29.
 */
@WebServlet("/admin/user")
public class AdminUserServlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p=req.getParameter("p");
        Integer pagenum= StringUtils.isNumeric(p)?Integer.valueOf(p):1;
        UserService userService=new UserService();
        Page<User> pageList=userService.findAllUser(pagenum);
        req.setAttribute("pageList",pageList);
        forword("/admin/adminuser",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer status=Integer.valueOf(req.getParameter("status"));
        String id=req.getParameter("id");
        status=status==1?2:1;
        Map<String,Object> result= Maps.newHashMap();
        UserService userService=new UserService();
        try{
            userService.updateStatus(id,status);
            result.put("state","success");
        }catch (ServiceException e){
                result.put("message",e.getMessage());
        }
        readerJson(result,resp);
    }
}
