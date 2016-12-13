package com.sxy.web;

import com.google.gson.Gson;
import com.sxy.entity.Message;
import com.sxy.service.MessageService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
@WebServlet("/timeline")
public class TimelineServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String MaxId=req.getParameter("MaxId");
       int id=0;
       if(StringUtils.isNumeric(MaxId)){
            id=Integer.parseInt(MaxId);
       }

        MessageService messageService=new MessageService();
       List<Message> messageList= messageService.findByMaxId(id);

        renderJson(messageList,resp);

    }
}
