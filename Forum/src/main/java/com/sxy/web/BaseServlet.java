package com.sxy.web;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/12/15.
 */
public class BaseServlet extends HttpServlet {

    public void forword(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/view/"+path+".jsp").forward(request,response);
    }

    public void rederText(String str, HttpServletResponse response) throws IOException {
      response.setContentType("text/plain,charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(str);
        out.flush();
        out.close();

    }


    public  void readerJson(Object obj,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String json=new Gson().toJson(obj);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
