package com.sxy.web.admin;

import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/admin/logout")
public class AdminLogoutServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        req.setAttribute("message","你已安全退出");
        forword("/admin/adminlogin",req,resp);
    }
}
