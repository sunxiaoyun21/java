package com.sxy.web.user;

import com.google.common.collect.Maps;
import com.qiniu.util.Auth;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.service.UserService;
import com.sxy.util.Config;
import com.sxy.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/19.
 */
@WebServlet("/setting")
public class SettingServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //计算七牛云存储的TOKEN
        Auth auth=Auth.create(Config.get("qiniu.ak"),Config.get("qiniu.sk"));
        String token=auth.uploadToken(Config.get("qiniu.name"));

        req.setAttribute("token",token);
        forword("/user/setting",req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if("profile".equals(action)){
            updateProfile(req,resp);
        }else  if("password".equals(action)){
            updatePassword(req,resp);
        }else if("avatar".equals(action)){
            updateAvatar(req,resp);
        }
    }
    //修改用户头像
    private void updateAvatar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filekey=req.getParameter("filekey");
        User user=getUser(req);

        Map<String,Object> result=Maps.newHashMap();
        UserService service=new UserService();
        service.updateAvatar(filekey,user);

        result.put("state","success");
        readerJson(result,resp);

    }

    //修改密码
    private void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String newpassword=req.getParameter("newpassword");
        String oldpassword=req.getParameter("oldpassword");
        User user=getUser(req);

        Map<String,Object> result=Maps.newHashMap();
        UserService service = new UserService();
        try {
            service.updatepassword(newpassword,oldpassword,user);
            result.put("state","success");
        }catch (ServiceException e){
            result.put("state","error");
            result.put("message",e.getMessage());
        }
        readerJson(result,resp);

    }

    /**
     * 修改基本资料
     * @param req
     * @param resp
     */
    private void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String email =req.getParameter("email");
            User user=getUser(req);

        UserService userService=new UserService();
        userService.updateEmail(email,user);

        Map<String,Object> result= Maps.newHashMap();
        result.put("state","success");
        readerJson(result,resp);
    }
}
