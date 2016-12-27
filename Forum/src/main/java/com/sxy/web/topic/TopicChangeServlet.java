package com.sxy.web.topic;

import com.google.common.collect.Maps;
import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.exception.ServiceException;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
@WebServlet("/topicChange")
public class TopicChangeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicid=req.getParameter("topicid");
        TopicService topicService=new TopicService();
        Topic topic=topicService.findtopicById(topicid);
        List<Node> nodeList= topicService.findAllNode();
        req.setAttribute("nodeList",nodeList);
        req.setAttribute("topic",topic);
        forword("/topic/topicchange",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String nodeid=req.getParameter("nodeid");
        String topicid=req.getParameter("topicid");


        Map<String,Object> result= Maps.newHashMap();

            if(StringUtils.isNumeric(topicid)){
                TopicService topicService=new TopicService();
                try{
                topicService.updateTopicById(title,content,nodeid,topicid);

                result.put("state","success");
                result.put("topicid",topicid);
                }catch (ServiceException e){
                    result.put("message",e.getMessage());
                }
            }else {
                result.put("message","参数有误");
            }

            readerJson(result,resp);


    }
}
