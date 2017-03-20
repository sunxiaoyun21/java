package com.sxy.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2017/3/20.
 */
public class LoginAction  extends BaseAction  {

    private String userName;
    private String password;
    private Integer code;

    public String execute() throws Exception{
        return SUCCESS;
    }

    public String login(){
        if("tom".equals(userName) && "123123".equals(password)){
            getSession().put("Current_user","tom");
            return SUCCESS;
        }else {
            code=1003;
            return ERROR;
        }

    }

    //get set


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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
