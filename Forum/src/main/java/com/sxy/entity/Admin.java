package com.sxy.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/12/28.
 */
public class Admin {
    private Integer id;
    private Timestamp creattime;
    private  String adminname;
    private  String password;
    private  String email;
    private  String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
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
}
