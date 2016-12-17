package com.sxy.dao;

import com.sxy.entity.Login;
import com.sxy.util.Dbhelp;

/**
 * Created by Administrator on 2016/12/17.
 */
public class LoginLogdao {
    public void save(Login log) {
        String sql="INSERT  INTO login(ip, user_id) VALUES (?,?)";
        Dbhelp.update(sql,log.getIp(),log.getUser_id());
    }
}
