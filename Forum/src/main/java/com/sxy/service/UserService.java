package com.sxy.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sxy.dao.LoginLogdao;
import com.sxy.dao.Notifydao;
import com.sxy.dao.UserDao;
import com.sxy.entity.Login;
import com.sxy.entity.Notify;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.util.Config;
import com.sxy.util.Page;
import com.sxy.util.SendEmail;
import org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/16.
 */
public class UserService {
    private Logger logger= LoggerFactory.getLogger(UserService.class);

    UserDao userDao=new UserDao();
    LoginLogdao loginLogdao=new LoginLogdao();
    Notifydao notifydao=new Notifydao();
    //发送激活邮件的TOKEN缓存
    private static Cache<String,String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(6, TimeUnit.HOURS)
            .build();
    //发送找回密码邮件的TOKEN缓存
    private  static Cache<String ,String> findcache=CacheBuilder.newBuilder()
            .expireAfterWrite(30,TimeUnit.MINUTES)
            .build();
    //限制操作频率过快的缓存
    private  static Cache<String,String> activecache=CacheBuilder.newBuilder()
            .expireAfterWrite(60,TimeUnit.SECONDS)
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
     * @param password
     * @param email
     * @param phone
     */
    public void saveUser(String username, String password, String email, String phone) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md2Hex(Config.get("user.pwd.salt")+password));
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
                String url="http://www.sxy.com/user/active?_="+uuid;
                //放入缓存
                cache.put(uuid,username);
                String html="<h3>亲爱的"+username+"</h3>,请点击<a href='"+url+"'>该链接</a>去激活你的账户";
                SendEmail.sendEmailHtml(email,"用户激活邮件",html);

            }
        });
        thread.start();
    }
    /**
     * 根据token激活对应的用户
     * @param token
     */
    public void activeUser(String token) {
        String username=cache.getIfPresent(token);
        if(username==null){
            throw new ServiceException("Token无效或已过期");
        }else {
            User user=userDao.findUser(username);
            if(user==null){
                throw  new ServiceException("无法找到该用户");
            }else {
                user.setStatus(User.STATUS_ACTVE);
                userDao.update(user);
                cache.invalidate(token);
            }
        }
    }
    /**
     * 用户登录
     * @param username
     * @param password
     * @param ip
     */
    public User login(String username, String password, String ip) {
        User user = userDao.findUser(username);
        if (user != null && DigestUtils.md5Hex(Config.get("user.pwd.salt") + password).equals(user.getPassword())) {
            if (user.getStatus().equals(User.STATUS_ACTVE)) {
                Login log = new Login();
                log.setIp(ip);
                log.setUser_id(user.getId());

                loginLogdao.save(log);
                return user;
            } else if (user.getStatus().equals(User.STATUS)) {
                throw new ServiceException("该账号未激活");
            } else {
                throw new ServiceException("该账号已被禁用");
            }
        } else {
            throw new ServiceException("账号或密码错误");
        }
    }

    /**
     * 用户找回密码
     * @param type email||phone
     * @param value email值或者phone的值
     * @param sessionId 客户端的sessionid，防止客户操作频率过快
     */
    public void findPassword(String type, String value, String sessionId) {
        if(activecache.getIfPresent(sessionId)==null){
            if("phone".equals(type)){
                //
            }else if("email".equals(type)){
              User user= userDao.findEmail(value);
              if(user!=null){
                  Thread thread=new Thread(new Runnable() {
                      @Override
                      public void run() {
                          String uuid=UUID.randomUUID().toString();
                          String url="http://www.sxy.com/resetpassword?token="+uuid;

                          findcache.put(uuid,user.getUsername());
                          String html=user.getUsername()+"</br>,请点击<a href='"+url+"'>该链接</a>进行找回密码操作，链接在30分钟内有效";
                          SendEmail.sendEmailHtml(value,"密码找回邮件",html);
                      }
                  });
                  thread.start();
              }
            }
            activecache.put(sessionId,"xxx");

        }else {
            throw new ServiceException("操作频率过快");
        }

    }

    /**
     * 根据用户找回密码的链接判断是哪个用户
     * @param token
     * @return
     */
    public User findpasswordToken(String token) {
        String user=findcache.getIfPresent(token);
        if(StringUtils.isEmpty(user)){
            throw new ServiceException("token过期或错误");
        }else {
            User username=userDao.findUser(user);
            if(username==null){
                throw new ServiceException("未找到该用户");
            }else {
                return username;
            }
        }
    }

    /**
     * 重置用户密码
     * @param password
     * @param token
     * @param id
     */
    public void reSetPassword(String password, String token, String id) {
        if(findcache.getIfPresent(token)==null){
            throw new ServiceException("token过期或错误");
        }else {
            String username=findcache.getIfPresent(token);
           User user=userDao.findUser(username);
            user.setPassword(DigestUtils.md5Hex(Config.get("user.pwd.salt")+password));
            userDao.update(user);

            findcache.invalidate(token);
        }
    }

    /**
     * 修改用户的基本资料中的email
     * @param email
     * @param user
     */
    public void updateEmail(String email, User user) {
        user.setEmail(email);
        userDao.update(user);
    }

    /**
     * 用户修改密码
     * @param newpassword
     * @param oldpassword
     * @param user
     */
    public void updatepassword(String newpassword, String oldpassword, User user) {
        if(DigestUtils.md5Hex(Config.get("user.pwd.salt")+oldpassword).equals(user.getPassword())){
           user.setPassword(DigestUtils.md5Hex(Config.get("user.pwd.salt")+newpassword));
           userDao.update(user);
        }else {
            throw new ServiceException("原始密码错误");
        }

    }

    /**
     * 修改用户头像
     * @param filekey
     * @param user
     */
    public void updateAvatar(String filekey, User user) {
        user.setAvatar(filekey);
        userDao.update(user);
    }

    public Page<User> findAllUser(Integer pagenum) {
        Integer count=userDao.count();
        Page<User> page=new Page<>(count,pagenum);
       List<User> userList=userDao.findAllUser();
       for(User user:userList){
           Login login=loginLogdao.findLogin(user.getId());
           user.setLogin(login);
       }
       page.setItems(userList);
       return page;
    }

    /**
     * 查询通知列表
     * @param user
     * @return
     */
    public List<Notify> findAllNotify(User user) {
        return notifydao.findAllNotify(user.getId());

    }

    public void updateStatus(String id, Integer status) {
        if(StringUtils.isNumeric(id)){
            User user=userDao.findById(Integer.valueOf(id));
            user.setStatus(status);
            userDao.update(user);
        }else {
            throw new ServiceException("参数异常");
        }
    }

    public void updateNotifyStateByIds(String ids) {
        String idArray[] = ids.split(",");
        for (int i= 0 ;i <idArray.length;i++ ){
            Notify notify = notifydao.findById(idArray[i]);
            notify.setState(Notify.STATEREAD);
            notify.setReadtime(new Timestamp(DateTime.now().getMillis()));
            notifydao.update(notify);
        }
    }
}
