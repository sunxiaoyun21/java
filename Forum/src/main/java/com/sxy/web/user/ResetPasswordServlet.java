package com.sxy.web.user;

import com.google.common.collect.Maps;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/18.
 */
@WebServlet("/resetpassword")
public class ResetPasswordServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String token=req.getParameter("token");
       if(StringUtils.isEmpty(token)){
           resp.sendError(404);
       }else {
           UserService userService=new UserService();

           try{
                User user=userService.findpasswordToken(token);
                req.setAttribute("user",user);
                req.setAttribute("token",token);
               forword("user/resetpassword",req,resp);
           }catch (ServiceException e){
                req.setAttribute("message",e.getMessage());
               forword("user/resetpassword",req,resp);
           }
       }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password=req.getParameter("password");
        String token=req.getParameter("token");
        String id=req.getParameter("id");

        Map<String,Object> result= Maps.newHashMap();
        UserService service=new UserService();
        try{
            service.reSetPassword(password,token,id);
            result.put("state","success");
        }catch (ServiceException e){
            result.put("state","error");
            result.put("message",e.getMessage());
        }
        readerJson(result,resp);

    }
}
