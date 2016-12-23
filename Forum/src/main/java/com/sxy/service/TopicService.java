package com.sxy.service;

import com.sxy.dao.Nodedao;
import com.sxy.dao.Replydao;
import com.sxy.dao.Topicdao;
import com.sxy.dao.UserDao;
import com.sxy.entity.Node;
import com.sxy.entity.Reply;
import com.sxy.entity.Topic;
import com.sxy.entity.User;
import com.sxy.exception.ServiceException;
import com.sxy.util.Config;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class TopicService {
    private Nodedao nodedao=new Nodedao();
    private Topicdao topicdao=new Topicdao();
    private UserDao userDao=new UserDao();
    private Replydao replydao=new Replydao();

    public List<Node> findAllNode() {
        return nodedao.findAllNode();
    }


    public Topic saveTopic(String title, String content, Integer nodeid, Integer userid) {
       //封装topic对象
        Topic topic=new Topic();
        topic.setTitle(title);
        topic.setContent(content);
        topic.setNode_id(nodeid);
        topic.setUser_id(userid);
        Integer topicid=topicdao.saveTopic(topic);
        topic.setId(topicid);

        return topic;
    }

    public  Topic findtopicById(String topicid) {
        if(StringUtils.isNumeric(topicid)){
           Topic topic= topicdao.findtopicById(topicid);
            if(topic!=null){
                //通过topic对象中的userid和nodeid来获取user和node对象,并set topic对象中
                User user=userDao.findById(topic.getUser_id());
                Node node=nodedao.findById(topic.getNode_id());
                user.setAvatar(Config.get("qiniu.domain")+user.getAvatar());
                topic.setUser(user);
                topic.setNode(node);
                return  topic;
            }else {
                throw  new  ServiceException("该贴不存在");
            }
        }else{
            throw  new ServiceException("参数有误");
        }

    }


    public void addReply(String topicid, String content, User user) {
        Reply reply=new Reply();
        reply.setTopic_id(Integer.valueOf(topicid));
        reply.setUser_id(user.getId());
        reply.setContent(content);

        replydao.addReply(reply);


    }
}
