package com.sxy.dao;

import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.entity.User;
import com.sxy.util.Config;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Topicdao {


    public Integer saveTopic(Topic topic) {
        String sql="INSERT INTO topic( title, content,  user_id, node_id,lastreplytime) VALUES(?,?,?,?,?)";
        return Dbhelp.insert(sql,topic.getTitle(),topic.getContent(),topic.getUser_id(),topic.getNode_id(),topic.getLastreplytime());
    }

    public Topic findtopicById(String topicid) {
        String sql="select*from topic where id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Topic.class),topicid);
    }

    public void update(Topic topic) {
        String sql="UPDATE topic SET title=?, content=?,clicknum=?,collectnum=?,thanknum=?,replynum=?,lastreplytime=?,user_id=?,node_id=? where id=?";
        Dbhelp.update(sql,topic.getTitle(),topic.getContent(),topic.getClicknum(),topic.getCollectnum(),topic.getThanknum(),topic.getReplynum(),topic.getLastreplytime(),topic.getUser_id(),topic.getNode_id(),topic.getId());
    }

    public int count(String nodeid) {
        String sql="select count(*) from topic where node_id=?";
        return Dbhelp.query(sql,new ScalarHandler<Long>(),nodeid).intValue();

    }
    public int count() {
        String sql="select count(*) from topic";
        return Dbhelp.query(sql,new ScalarHandler<Long>()).intValue();


    }

    public List<Topic> findAllTopic(HashMap<String, Object> map) {
        String nodeid=map.get("nodeid")==null?null:String.valueOf(map.get("nodeid"));
        String sql="select user.username,user.avatar,topic.* from user,topic where topic.user_id=user.id";
        String where="";
        List<Object> list=new ArrayList<>();
        if(StringUtils.isNotEmpty(nodeid)){
            where+=" and node_id=?";
            list.add(nodeid);
        }
        where+=" order by topic.lastreplytime desc limit ?,?";
        list.add(map.get("start"));
        list.add(map.get("pagesize"));
        sql+=where;
       return Dbhelp.query(sql, new AbstractListHandler<Topic>() {
            @Override
            protected Topic handleRow(ResultSet resultSet) throws SQLException {
                Topic topic=new BasicRowProcessor().toBean(resultSet,Topic.class);
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setAvatar(Config.get("qiniu.domain")+resultSet.getString("avatar"));
                topic.setUser(user);
                return topic;
            }
        },list.toArray());
    }
}
