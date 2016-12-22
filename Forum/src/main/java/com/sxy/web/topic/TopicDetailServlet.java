package com.sxy.web.topic;

import com.google.common.collect.Maps;
import com.sxy.entity.Topic;
import com.sxy.exception.ServiceException;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/21.
 */
@WebServlet("/topicdetail")
public class TopicDetailServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicid=req.getParameter("topicid");
        TopicService topicService=new TopicService();
        Map<String,Object> result= Maps.newHashMap();



        try {
            Topic topic=topicService.findtopicById(topicid);
            result.put("state","success");
           req.setAttribute("topic",topic);
            forword("/topic/topicdetail",req,resp);
        }catch (ServiceException e){
            resp.sendError(404);
        }



    }
}