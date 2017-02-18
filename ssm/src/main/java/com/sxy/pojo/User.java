package com.sxy.pojo;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleNames(){
       List<String> viewNames= Lists.newArrayList(Collections2.transform(getRoleList(), new Function<Role, String>() {
           @Override
           public String apply(Role role) {
               return role.getViewName();
           }
       }));
       StringBuilder sb=new StringBuilder();
       for (String viewName:viewNames){
           sb.append(viewName).append(" ");
       }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
