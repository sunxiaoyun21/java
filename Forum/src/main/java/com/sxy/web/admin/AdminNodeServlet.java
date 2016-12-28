package com.sxy.web.admin;

import com.sxy.entity.Node;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/admin/node")
public class AdminNodeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TopicService topicService=new TopicService();
        List<Node> nodeList=topicService.findAllNode();
        req.setAttribute("nodeList",nodeList);
        forword("/admin/adminnode",req,resp);
    }
}
