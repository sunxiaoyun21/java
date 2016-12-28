package com.sxy.web.admin;

import com.google.common.collect.Maps;
import com.sxy.entity.Node;
import com.sxy.exception.ServiceException;
import com.sxy.service.NodeService;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/updatenode")
public class UpdateNodeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nodeid=req.getParameter("nodeid");
        TopicService topicService=new TopicService();
        try{
            Node node=topicService.findNodeById(nodeid);
            req.setAttribute("node",node);
            forword("/admin/updatenode",req,resp);
        }catch (ServiceException e){
            resp.sendError(404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nodeid=req.getParameter("nodeid");
        String nodename=req.getParameter("nodename");
        NodeService nodeService=new NodeService();
        Map<String,Object> result= Maps.newHashMap();
        try{
            nodeService.updateNode(nodeid,nodename);
            result.put("state","success");
        }catch (ServiceException e){
            result.put("message",e.getMessage());
        }
      readerJson(result,resp);
    }
}
