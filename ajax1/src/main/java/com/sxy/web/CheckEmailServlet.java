package com.sxy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet("/checkemail")
public class CheckEmailServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String mail=req.getParameter("mail");

          PrintWriter out=resp.getWriter();
            if("479338314@qq.com".equals(mail)){
                out.print("false");
            }else {
                out.print("true");
            }

    }
}
