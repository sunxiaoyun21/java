package com.sxy.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Reply {
    private Integer id;
    private  String content;
    private Timestamp creattime;
    private  Integer topic_id;
    private  Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
