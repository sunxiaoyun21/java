package com.sxy.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/27.
 */
public class Notify {
    //已读
    public static final Integer STATEREAD=1;
    //未读
    public static final Integer STATEUNREAD=0;




    private Integer id;
    private  String content;
    private Timestamp creattime;
    private  Integer state;

    private Timestamp readtime;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getReadtime() {
        return readtime;
    }

    public void setReadtime(Timestamp readtime) {
        this.readtime = readtime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
