package com.sxy.web;

import com.sxy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 */
@WebServlet("/user.xml")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(001, "张三", "上海");
        User user2 = new User(002, "tom", "Franch");
        User user3 = new User(003, "jan", "America");

        List<User> userList= Arrays.asList(user,user2,user3);

        //设置响应的字符编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应头的MIME TYPE
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter out =resp.getWriter();
        out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.print("<users>");
            for(User u:userList){
                out.print("<user id=\""+u.getId()+"\">");
                out.print("<name>"+u.getName()+"</name>");
                out.print("<address>"+u.getAddress()+"</address>");
                out.print("</user>");
            }
        out.print("</users>");
            out.flush();
            out.close();

    }
}
