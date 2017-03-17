package com.sxy.action;

/**
 * Created by Administrator on 2017/3/17.
 */
public class HelloAction {


    private String code;

    public String execute(){
        System.out.println("hello------------------");
        return "success";
    }

    public String add(){
        code="1234";
        System.out.println("add...................");
        return "success";
    }

    //get set

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
