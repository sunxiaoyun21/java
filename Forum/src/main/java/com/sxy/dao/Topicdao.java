package com.sxy.dao;

import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Topicdao {


    public Integer saveTopic(Topic topic) {
        String sql="INSERT INTO topic( title, content,  user_id, node_id) VALUES(?,?,?,?)";
        return Dbhelp.insert(sql,topic.getTitle(),topic.getContent(),topic.getUser_id(),topic.getNode_id());
    }

    public Topic findtopicById(String topicid) {
        String sql="select*from topic where id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Topic.class),topicid);
    }
}
