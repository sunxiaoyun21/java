package com.sxy.dao;

import com.sxy.entity.Login;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Administrator on 2016/12/17.
 */
public class LoginLogdao {
    public void save(Login log) {
        String sql="INSERT  INTO login(ip, user_id) VALUES (?,?)";
        Dbhelp.update(sql,log.getIp(),log.getUser_id());
    }

    public Login findLogin(Integer id) {
        String sql="SELECT *FROM login WHERE user_id=? ORDER BY logintime  DESC LIMIT 0,1";
        return Dbhelp.query(sql,new BeanHandler<>(Login.class),id);

    }
}
