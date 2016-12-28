package com.sxy.web.admin;

import com.sxy.exception.ServiceException;
import com.sxy.service.NodeService;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/delnode")
public class DelNodeServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        NodeService nodeService=new NodeService();
        try {
            nodeService.delNodeById(id);
            rederText("success",resp);
        }catch (ServiceException e){
            rederText(e.getMessage(),resp);
        }

    }
}
