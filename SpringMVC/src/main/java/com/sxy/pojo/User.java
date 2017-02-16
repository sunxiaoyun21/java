package com.sxy.pojo;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private  String address;
    private List<Roles> rolesList;

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoleNames() {
        List<String> roles= Lists.newArrayList(Collections2.transform(getRolesList(), new Function<Roles, String>() {
            @Override
            public String apply(Roles role) {
                return role.getRole();
            }
        }));

        StringBuilder sb = new StringBuilder();
        for(String role : roles) {
            sb.append(role).append(" ");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
