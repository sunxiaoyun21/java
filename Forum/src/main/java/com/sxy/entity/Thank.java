package com.sxy.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Thank {
    private Integer topic_id;
    private  Integer user_id;
    private Timestamp cerattime;

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

    public Timestamp getCerattime() {
        return cerattime;
    }

    public void setCerattime(Timestamp cerattime) {
        this.cerattime = cerattime;
    }
}
