package com.sxy.dao;

import com.sxy.entity.Thank;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Thankdao {
    public Thank findThankByUserAndTopic(String topicid, Integer id) {
        String sql="select*from thank where topic_id=? and user_id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Thank.class),topicid,id);
    }

    public void addThank(Thank thank) {
        String sql="INSERT INTO thank(topic_id, user_id) VALUES (?,?)";
        Dbhelp.update(sql,thank.getTopic_id(),thank.getUser_id());
    }

    public void unthank(String topicid, Integer id) {
    String sql="DELETE FROM thank WHERE user_id=? AND thank.topic_id=?";
    Dbhelp.update(sql,id,topicid);
    }

    public void delTopicById(String id) {
        String sql="delete from thank where topic_id=?";
        Dbhelp.update(sql,id);
    }
}
