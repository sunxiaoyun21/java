package com.sxy.action;

import com.sxy.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class UserAction {

    private User user;
    private List<String> list;

    public String execute(){
        list= Arrays.asList("a,","b","c");
        return "success";
    }

    public String save(){
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        return "success";
    }




    //get set


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
