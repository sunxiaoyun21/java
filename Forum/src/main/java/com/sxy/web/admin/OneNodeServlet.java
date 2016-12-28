package com.sxy.web.admin;

import com.sxy.service.NodeService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/onenode")
public class OneNodeServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nodeid=req.getParameter("nodeid");
        String nodename=req.getParameter("nodename");
        nodename= com.sxy.util.StringUtils.toUtf8(nodename);
        NodeService nodeService = new NodeService();
        String result=nodeService.oneNodename(nodeid,nodename);
        rederText(result,resp);
    }
}
