package com.sxy.service;

import com.sxy.dao.*;
import com.sxy.entity.Admin;
import com.sxy.entity.Node;
import com.sxy.entity.Topic;
import com.sxy.exception.ServiceException;
import com.sxy.util.Config;
import com.sxy.util.Page;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Administrator on 2016/12/28.
 */
public class AdminService {
    private Admindao admindao=new Admindao();
    private Topicdao topicdao=new Topicdao();
    private Nodedao nodedao=new Nodedao();
    private Replydao replydao=new Replydao();
    private Collectdao collectdao=new Collectdao();
    private  Thankdao thankdao=new Thankdao();


    public Admin findAdmin(String adminname, String password, String ip) {
        Admin admin=admindao.findAdmin(adminname);
        if(admin!=null && DigestUtils.md5Hex(Config.get("user.pwd.salt")+password).equals(admin.getPassword())){
            return  admin;
        }else {
            throw  new ServiceException("该管理员不存在");
        }

    }

    public void deltopicById(String id) {
        //删除收藏的帖子
        collectdao.delTopicById(id);
        //删除感谢的帖子
        thankdao.delTopicById(id);
        //删除主题的回复
        replydao.delReplyById(id);
        //更新节点下的主题数量
        //根据topicid来查nodeid
        Topic topic=topicdao.findtopicById(id);
        if(topic!=null){
            //删除节点下的主题数量
            Node node=nodedao.findById(topic.getNode_id());
            node.setTopicnum(node.getTopicnum()-1);
            nodedao.update(node);
            //删除主题
            topicdao.delById(id);
        }else {
            throw  new ServiceException("该主题不存在或已被删除");
        }


    }


}
