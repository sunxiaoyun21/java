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
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
@WebServlet("/data.json")
public class JsonDataServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           resp.setCharacterEncoding("UTF-8");
           resp.setContentType("application/json;charset=UTF-8");

            User user=new User(001,"张翰","北京");
            User user1 =new User(002,"赵丽颖","河北");
            User user2=new User(003,"李四","河南");

            List<User> userList=Arrays.asList(user,user1,user2);

            String json=new Gson().toJson(userList);

            PrintWriter out=resp.getWriter();
            out.print(json);
            out.flush();
            out.close();

    }
}
