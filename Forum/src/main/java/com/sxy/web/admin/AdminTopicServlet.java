package com.sxy.web.admin;

import com.google.common.collect.Maps;
import com.sxy.entity.Topic;
import com.sxy.exception.ServiceException;
import com.sxy.service.AdminService;
import com.sxy.service.TopicService;
import com.sxy.util.Page;
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
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/admin/topic")
public class AdminTopicServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p=req.getParameter("p");
        Integer pagenum= StringUtils.isNumeric(p)?Integer.valueOf(p):1;
        TopicService topicService=new TopicService();
        Page<Topic>  page=topicService.findAllTopic("",pagenum);
        req.setAttribute("page",page);
        forword("/admin/admintopic",req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        AdminService adminService=new AdminService();
        Map<String,Object> result= Maps.newHashMap();
        try {
            adminService.deltopicById(id);
            rederText("success",resp);
        }catch (ServiceException e){
            rederText(e.getMessage(),resp);
        }


    }
}
