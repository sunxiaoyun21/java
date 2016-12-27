package com.sxy.web.topic;

import com.google.common.collect.Maps;
import com.sxy.entity.Topic;
import com.sxy.entity.User;
import com.sxy.service.TopicService;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 */
@WebServlet("/collect")
public class CollectServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text=req.getParameter("text");
        String topicid=req.getParameter("topicid");
        User user= (User) req.getSession().getAttribute("curr");
        TopicService topicService=new TopicService();
        Map<String,Object> result= Maps.newHashMap();

        if(StringUtils.isNotEmpty(text) &&StringUtils.isNumeric(topicid)){
            if(text.equals("collect")){
                topicService.collect(topicid,user);
                result.put("state","success");
            }else if(text.equals("uncollect")){
                topicService.uncollect(topicid,user);
                result.put("state","success");
            }
           Topic topic= topicService.findtopicById(topicid);
          result.put("collectnum",topic.getCollectnum());

        }else {
            result.put("message","参数异常");
        }
        readerJson(result,resp);
    }
}
