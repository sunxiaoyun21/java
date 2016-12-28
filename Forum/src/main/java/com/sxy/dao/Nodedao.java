package com.sxy.dao;

import com.sxy.entity.Node;
import com.sxy.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Nodedao {

    public List<Node> findAllNode() {
        String sql="SELECT *FROM node";
        return Dbhelp.query(sql,new BeanListHandler<>(Node.class));
    }

    public Node findById(Integer node_id) {
        String sql="select*from node where id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Node.class),node_id);
    }

    public void update(Node node) {
        String sql="UPDATE node SET topicnum=? ,nodename=? where id=?";
        Dbhelp.update(sql,node.getTopicnum(),node.getNodename(),node.getId());
    }

    public Node findByName(String nodename) {
        String sql="select *from node where nodename=?";
        return Dbhelp.query(sql, new BeanHandler<>(Node.class),nodename);

    }

    public Node findNodeById(String nodeid) {
        String sql="select*from node where id=?";
        return Dbhelp.query(sql,new BeanHandler<Node>(Node.class),nodeid);
    }

    public void del(String id) {
        String sql="delete from node where id=?";
        Dbhelp.update(sql,id);
    }
}
