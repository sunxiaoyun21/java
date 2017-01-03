package com.sxy.web.user;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sxy.entity.Notify;
import com.sxy.entity.User;
import com.sxy.service.UserService;
import com.sxy.web.BaseServlet;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/27.
 */
@WebServlet("/notify")
public class NotifyServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("curr");
        UserService userService=new UserService();
        List<Notify> notifyList=userService.findAllNotify(user);
        req.setAttribute("notifyList",notifyList);
        forword("/user/notify",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user= (User) req.getSession().getAttribute("curr");
        Map<String,Object> result=Maps.newHashMap();
       //根据用户id和通知状态查询未读列表
        //根据guava的collection2.filter过滤未读消息通知数据
        List<Notify> notifyList=new UserService().findAllNotify(user);
        List<Notify> unreadList= Lists.newArrayList(Collections2.filter(notifyList, new Predicate<Notify>() {
            @Override
            public boolean apply(Notify notify) {
               return  notify.getState()==0;
            }

        }));
        result.put("data",unreadList.size());
        result.put("state","success");
        readerJson(result,resp);
    }
}
