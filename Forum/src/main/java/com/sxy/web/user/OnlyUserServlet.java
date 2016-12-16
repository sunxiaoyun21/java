package com.sxy.web.user;


import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;
import com.sxy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/16.
 */
@WebServlet("/only/user")
public class OnlyUserServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        //处理url中中文乱码
        username= StringUtils.toUtf8(username);
        UserService userService=new UserService();
        boolean result=userService.findUser(username);

        if(result){
            rederText("true",resp);
        }else {
            rederText("false",resp);
        }

    }
}
