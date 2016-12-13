package com.sxy.web;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/13.
 */
public class BaseServlet extends HttpServlet {

    /**
     * 给客户端响应一个json数据
     * @param  obj 要被转换成json的对象
     * @param response
     * @throws IOException
     */

    public  void renderJson(Object obj,HttpServletResponse response) throws IOException {
        String json=new Gson().toJson(obj);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
