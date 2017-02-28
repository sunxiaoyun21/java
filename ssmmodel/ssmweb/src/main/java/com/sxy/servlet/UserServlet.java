package com.sxy.servlet;

import com.sxy.pojo.User;
import com.sxy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/28.
 */
@WebServlet("/hello")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserService();
        User user=new User();
        user.setName("jack");
        user.setAge(18);
        userService.save(user);

        resp.sendRedirect("hello.jsp");
    }
}
