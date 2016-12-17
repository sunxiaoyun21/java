package com.sxy.web.user;

import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/17.
 */
@WebServlet("/user/active")
public class UseractiveServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token=req.getParameter("_");
        if(StringUtils.isEmpty(token)){
            resp.sendError(404);
        }else {
            UserService userService=new UserService();
            try{
                userService.activeUser(token);
                forword("user/success",req,resp);
            }catch (ServiceException e){
                req.setAttribute("message",e.getMessage());
                forword("user/error",req,resp);
            }

        }
    }
}
