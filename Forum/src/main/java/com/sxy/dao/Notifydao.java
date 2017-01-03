package com.sxy.dao;

import com.sxy.entity.Notify;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Notifydao {
    public List<Notify> findAllNotify(Integer id) {
        String sql="select * from notify where user_id=? ORDER BY readtime, creattime";
        return Dbhelp.query(sql,new BeanListHandler<>(Notify.class),id);
    }
    public void save(Notify notify) {
        String sql = "insert into notify (user_id,content,state) values(?,?,?)";
       Dbhelp.update(sql,notify.getUser_id(),notify.getContent(),notify.getState());
    }
    public Notify findById(String s) {
        String sql="select *from notify where id=?";
        return  Dbhelp.query(sql,new BeanHandler<>(Notify.class),s);
    }

    public void update(Notify notify) {
        String sql="update notify set state = ?,readtime = ? where id = ?";
        Dbhelp.update(sql,notify.getState(),notify.getReadtime(),notify.getId());
    }
}
