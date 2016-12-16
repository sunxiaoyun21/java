package com.sxy.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sxy.dao.UserDao;
import com.sxy.entity.User;
import com.sxy.util.Config;
import com.sxy.util.SendEmail;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/16.
 */
public class UserService {

    UserDao userDao=new UserDao();
    //发送激活邮件的TOKEN缓存
    private static Cache<String,String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(6, TimeUnit.HOURS)
            .build();

    /**
     * 效验用户名是否能用
     * @param username
     * @return
     */
    public boolean findUser(String username) {

        String name= Config.get("no.signup.name");
        List<String> stringList= Arrays.asList(name.split(","));
        if(stringList.contains(username)){
            return false;
        }
        return  userDao.findUser(username)==null;
    }

    public User findEmail(String email) {
        return userDao.findEmail(email);
    }

    /**
     * 新用户注册
     * @param username
     * @param passsword
     * @param email
     * @param phone
     */
    public void saveUser(String username, String passsword, String email, String phone) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md2Hex(Config.get("user.pwd.salt")+passsword));
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar(User.AVATAR);
        user.setStatus(User.STATUS);

        userDao.save(user);
        //子线程去发送邮件
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //给客户发送邮件激活
                String uuid= UUID.randomUUID().toString();
                String url="http://www.sxy.comuser/user/active?_="+uuid;
                //放入缓存
                cache.put(uuid,username);
                String html="<h3>亲爱的"+username+"</h3>,请点击<a href='"+url+"'>该链接</a>去激活你的账户";
                SendEmail.sendEmailHtml(email,"用户激活邮件",html);

            }
        });
        thread.start();
    }
}
