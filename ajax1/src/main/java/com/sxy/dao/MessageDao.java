package com.sxy.dao;

import com.sxy.entity.Message;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MessageDao {

    public List<Message> findAll(){
        String sql="select *from message order by id desc";
        return Dbhelp.query(sql,new BeanListHandler<>(Message.class));
    }

    public List<Message> fingByMaxId(int MaxId) {
        String sql="select *from message where id > ? order by id desc";
        return Dbhelp.query(sql,new BeanListHandler<>(Message.class),MaxId);
    }
}
