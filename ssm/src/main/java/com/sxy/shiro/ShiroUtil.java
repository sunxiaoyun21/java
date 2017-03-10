package com.sxy.shiro;

import com.sxy.pojo.User;
import org.apache.shiro.SecurityUtils;

/**
 * Created by Administrator on 2017/3/10.
 */
public class ShiroUtil {
    public static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static String getCurrentUserName(){
       return getCurrentUser().getUserName();
    }
    public static Integer getCurrentUserId(){
        return getCurrentUser().getId();
    }

    /**
     * 判断当前登录是否为市场部的人
     * 这是后端来设置权限
     * @return
     */
    public static boolean isSales(){
        return SecurityUtils.getSubject().hasRole("role_sales");
    }
}
