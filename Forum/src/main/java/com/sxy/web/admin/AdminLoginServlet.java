package com.sxy.web.admin;

import com.google.common.collect.Maps;
import com.sxy.entity.Admin;
import com.sxy.exception.ServiceException;
import com.sxy.service.AdminService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forword("/admin/adminlogin",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminname=req.getParameter("adminname");
        String password=req.getParameter("password");
        String IP=req.getLocalAddr();
        AdminService adminService=new AdminService();
        Map<String,Object> result= Maps.newHashMap();
        try{
            Admin admin =adminService.findAdmin(adminname,password,IP);
            HttpSession session=req.getSession();
            session.setAttribute("admin",admin);
            result.put("state","success");
        }catch (ServiceException e){
            result.put("state","error");
            result.put("message",e.getMessage());
        }
       readerJson(result,resp);
    }
}
