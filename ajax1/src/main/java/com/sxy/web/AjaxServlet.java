package com.sxy.web;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/5.
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
        name=new String(name.getBytes("ISO8859-1"),"UTF-8");
        System.out.println("hello ajax"+"->"+name);
        PrintWriter out=resp.getWriter();
        out.print("hello");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
        System.out.print("hello post"+"->"+name);

        PrintWriter out=resp.getWriter();
        if("tom".equals(name)){
            System.out.println("账号被占用");
            out.print("不能用");
        }else {
            System.out.println("账号可用");
            out.print("可用");
        }
        out.flush();
        out.close();
    }
}
