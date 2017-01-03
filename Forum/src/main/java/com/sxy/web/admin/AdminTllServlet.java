package com.sxy.web.admin;

import com.sxy.entity.Topic;
import com.sxy.entity.TopicReplyCount;
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

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/admin/ttl")
public class AdminTllServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String p=req.getParameter("p");
      Integer pagenum= StringUtils.isNumeric(p)?Integer.valueOf(p):1;
       TopicService topicService=new TopicService();
        Page<TopicReplyCount> pageList=topicService.findTopicCount(pagenum);
        req.setAttribute("pageList" ,pageList);

        forword("/admin/adminttl",req,resp);
    }
}
