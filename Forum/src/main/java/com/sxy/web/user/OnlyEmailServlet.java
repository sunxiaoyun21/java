package com.sxy.web.user;

import com.sxy.entity.User;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/16.
 */
@WebServlet("/only/email")
public class OnlyEmailServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String type=req.getParameter("type");

        if(StringUtils.isNotEmpty(type) &&"1".equals(type)){
                User user=getUser(req);
                if(user!=null){
                    if(user.getEmail().equals(email)){
                        rederText("true",resp);
                        return;
                    }
                }
        }
        UserService userService=new UserService();
        User emaill = userService.findEmail(email);

        if(emaill == null){
            rederText("true",resp);
        }else {
            rederText("false",resp);
        }
    }
}
