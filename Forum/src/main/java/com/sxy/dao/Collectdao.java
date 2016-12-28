package com.sxy.dao;

import com.sxy.entity.Collect;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Collectdao {
    public Collect findCollectByUserAndTopic(String topicid, Integer id) {
        String sql="SELECT *FROM user_has_topic WHERE user_id =? AND topic_id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Collect.class),id,topicid);
    }

    public void addCollect(Collect collect) {
        String sql="INSERT  INTO user_has_topic(user_id, topic_id) VALUES (?,?)";
        Dbhelp.update(sql,collect.getUser_id(),collect.getTopic_id());
    }

    public void uncollect(String topicid, Integer id) {
        String sql="DELETE FROM user_has_topic WHERE user_id=? AND topic_id=?";
        Dbhelp.update(sql,id,Integer.valueOf(topicid));
    }

    public void delTopicById(String id) {
        String sql="delete from user_has_topic where topic_id=?";
        Dbhelp.update(sql,id);
    }
}
