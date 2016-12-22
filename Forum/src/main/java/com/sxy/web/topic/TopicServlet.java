package com.sxy.web.topic;

import com.google.common.collect.Maps;
import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.entity.User;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/21.
 */
@WebServlet("/newtopic")
public class TopicServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TopicService topicService=new TopicService();
        List<Node> nodeList= topicService.findAllNode();
        req.setAttribute("nodeList",nodeList);


        forword("/topic/newtopic",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String nodeid=req.getParameter("nodeid");

       User user= (User) req.getSession().getAttribute("curr");
        TopicService topicService=new TopicService();
       Topic topic= topicService.saveTopic(title,content,Integer.valueOf(nodeid),user.getId());
        Map<String,Object> result= Maps.newHashMap();
        result.put("state","success");
        result.put("topic",topic);
        readerJson(result,resp);
    }
}
