package com.sxy.web.topic;

import com.google.common.collect.Maps;
import com.sxy.entity.*;
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
 * Created by Administrator on 2016/12/21.
 */
@WebServlet("/topicdetail")
public class TopicDetailServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topicid=req.getParameter("topicid");
        TopicService topicService=new TopicService();
        Map<String,Object> result= Maps.newHashMap();

        try {
            Topic topic=topicService.findtopicById(topicid);
            //更新表中的clicknum数量
            topic.setClicknum(topic.getClicknum()+1);
            topicService.updateReply(topic);
            //获取topic中的回复列表
            List<Reply> replyList=topicService.findReplylistById(topicid);
            req.setAttribute("replyList",replyList);
            result.put("state","success");
           req.setAttribute("topic",topic);

            User user= (User) req.getSession().getAttribute("curr");
            //判断用户是否收藏该主题
            if(user!=null && StringUtils.isNumeric(topicid)){
                Collect collect=topicService.findCollectByUserAndTopic(topicid,user);
                req.setAttribute("collect",collect);
            }
            //判断用户是否感谢该主题
            if(user!=null &&StringUtils.isNumeric(topicid)){
                Thank thank=topicService.findThankByUserAndTopic(topicid,user);
                req.setAttribute("thank",thank);
            }
            forword("/topic/topicdetail",req,resp);
        }catch (ServiceException e){
            resp.sendError(404);
        }



    }
}
