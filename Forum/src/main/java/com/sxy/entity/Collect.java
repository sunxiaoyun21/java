package com.sxy.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Collect {
    private  Integer user_id;
    private Integer topic_id;
    private Timestamp creattime;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }
}
