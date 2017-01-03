package com.sxy.web.admin;

import com.google.common.collect.Maps;
import com.sxy.entity.Node;
import com.sxy.exception.ServiceException;
import com.sxy.service.NodeService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/3.
 */
@WebServlet("/firstnode")
public class FirstNodeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String node=req.getParameter("node");
        node= com.sxy.util.StringUtils.toUtf8(node);
        NodeService nodeService=new NodeService();
       String result= nodeService.firstNodeName(node);
       rederText(result,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String node=req.getParameter("node");
        NodeService nodeService=new NodeService();
        nodeService.saveNode(node);

        Map<String,Object> result= Maps.newHashMap();
        try {
            result.put("state","success");
            readerJson(result,resp);
        }catch (ServiceException e){
            result.put("message",e.getMessage());
        }

    }
}
