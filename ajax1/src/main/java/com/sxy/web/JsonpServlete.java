package com.sxy.web;

import com.google.gson.Gson;
import com.sxy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet("/jsonp")
public class JsonpServlete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = new User(001, "张三", "上海");
        String json=new Gson().toJson(user);

        PrintWriter out=resp.getWriter();
        out.print(method+"("+json+")");
        out.flush();
        out.close();
    }
}
