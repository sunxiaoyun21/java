package com.sxy.service;

import com.sxy.dao.MessageDao;
import com.sxy.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MessageService {
    private  MessageDao messageDao=new MessageDao();

    public List<Message> findAll(){
        return messageDao.findAll();
    }

    public List<Message> findByMaxId(int MaxId) {
        return messageDao.fingByMaxId(MaxId);
    }
}
