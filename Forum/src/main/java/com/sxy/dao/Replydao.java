package com.sxy.dao;

import com.sxy.entity.Reply;
import com.sxy.entity.Topic;
import com.sxy.entity.User;
import com.sxy.util.Config;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */
public class Replydao {
    public void addReply(Reply reply) {
        String sql="INSERT  INTO reply(content, topic_id, user_id) VALUES (?,?,?)";
        Dbhelp.update(sql,reply.getContent(),reply.getTopic_id(),reply.getUser_id());
    }

    public List<Reply> findlistBytopicId(String topicid) {
        String sql="SELECT user.avatar,user.username,reply.* FROM reply,user WHERE reply.user_id =user.id AND topic_id=?";
        return Dbhelp.query(sql, new AbstractListHandler<Reply>() {
            @Override
            protected Reply handleRow(ResultSet resultSet) throws SQLException {
                Reply reply=new BasicRowProcessor().toBean(resultSet,Reply.class);
                User user=new User();
                user.setAvatar(Config.get("qiniu.domain")+resultSet.getString("avatar"));
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                reply.setUser(user);
                return reply;



            }
        }, topicid);
    }
}
