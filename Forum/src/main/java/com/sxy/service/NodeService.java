package com.sxy.service;

import com.sxy.dao.Nodedao;
import com.sxy.entity.Node;
import com.sxy.exception.ServiceException;
import com.sxy.web.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28.
 */

public class NodeService  {
    private Nodedao nodedao=new Nodedao();
    public String oneNodename(String nodeid, String nodename) {
        //根据nodeid查询node，并判断nodename是否等于node里的nodename
        Node node=nodedao.findById(Integer.valueOf(nodeid));
           if(nodename.equals(node.getNodename())){
            return "true";
           }else {
               Node nodename1=nodedao.findByName(nodename);
               if(nodename1==null){
                   return "true";
               }
           }
            return "false";
    }

    public void updateNode(String nodeid, String nodename) {
        if(StringUtils.isNumeric(nodeid) && StringUtils.isNotEmpty(nodename)){
            Node node=nodedao.findById(Integer.valueOf(nodeid));
            node.setNodename(nodename);
            nodedao.update(node);
        }else {
            throw new ServiceException("参数异常");
        }
    }

    public void delNodeById(String id) {
        Node node=nodedao.findNodeById(id);
        if(node.getTopicnum()>0){
            throw  new ServiceException("该节点下已有主题不可删除");
        }else {
            nodedao.del(id);
        }

    }


    public String firstNodeName(String node) {
        Node node1=nodedao.findByName(node);
        if(node1==null){
            return "true";
        }else {
            return "false";
        }
    }

    public void saveNode(String nodeName) {
        if(StringUtils.isNotEmpty(nodeName)){
            Node node=new Node();
            node.setNodename(nodeName);
            nodedao.saveNode(node);
        }else {
            throw new  ServiceException("参数异常");
        }

    }
}
