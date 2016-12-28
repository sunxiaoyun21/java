package com.sxy.dao;

import com.sxy.entity.Admin;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Administrator on 2016/12/28.
 */
public class Admindao {
    public Admin findAdmin(String adminname) {
        String sql="select*from admin where adminname=?";
        return Dbhelp.query(sql,new BeanHandler<>(Admin.class),adminname);
    }
}
