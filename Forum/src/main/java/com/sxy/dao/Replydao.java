package com.sxy.dao;

import com.sxy.entity.Reply;
import com.sxy.util.Dbhelp;

/**
 * Created by Administrator on 2016/12/23.
 */
public class Replydao {
    public void addReply(Reply reply) {
        String sql="INSERT  INTO reply(content, topic_id, user_id) VALUES (?,?,?)";
        Dbhelp.update(sql,reply.getContent(),reply.getTopic_id(),reply.getUser_id());
    }
}
