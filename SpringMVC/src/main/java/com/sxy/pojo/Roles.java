package com.sxy.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/13.
 */
public class Roles implements Serializable {

    private  Integer id;
    private  String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
