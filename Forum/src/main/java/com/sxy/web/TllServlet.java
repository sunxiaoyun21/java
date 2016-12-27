package com.sxy.web;

import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.service.TopicService;
import com.sxy.util.Page;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
@WebServlet("/ttl")
public class TllServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nodeid=req.getParameter("nodeid");
        String p=req.getParameter("p");
        Integer pagenum= StringUtils.isNumeric(p)?Integer.valueOf(p):1;
        if(StringUtils.isNotEmpty(nodeid)&&!StringUtils.isNumeric(nodeid)){
            forword("index",req,resp);
            return;
        }


        TopicService topicService=new TopicService();
        List<Node> nodeList=topicService.findAllNode();
        Page<Topic> topicPage=topicService.findAllTopic(nodeid,pagenum);

        req.setAttribute("topicPage",topicPage);

        req.setAttribute("nodeList",nodeList);
        forword("index",req,resp);

    }
}
