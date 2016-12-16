package com.sxy.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/15.
 */
public class User implements Serializable {
    //新用户默认的头像
    public static final String AVATAR="images.jpg";
    //新用户默认状态
    public  static  final Integer STATUS=0;
    //激活状态
    public  static  final Integer STATUS_ACTVE=1;
    //禁用状态
    public  static  final Integer STATUS_DANGER=2;





    private  Integer id;
    private String Username;
    private  String password;
    private String email;
    private String phone;
    private Integer status;
    private Timestamp creattime;
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
