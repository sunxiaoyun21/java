package com.sxy.web.topic;

import com.sxy.entity.User;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/23.
 */
@WebServlet("/reply")
public class ReplyServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicid=req.getParameter("topicid");
        String content=req.getParameter("content");
        User user= (User) req.getSession().getAttribute("curr");
        TopicService topicService=new TopicService();

        if(StringUtils.isNumeric(topicid)){
            topicService.addReply(topicid,content,user);
        }else {
            resp.sendError(404);
        }

      resp.sendRedirect("/topicdetail?topicid="+topicid);

    }
}
