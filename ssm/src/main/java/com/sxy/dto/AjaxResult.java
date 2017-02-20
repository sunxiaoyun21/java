package com.sxy.dto;

import lombok.Data;

/**
 * Created by Administrator on 2017/2/20.
 */
@Data
public class AjaxResult {

    public static final String SUCCESS="success";
    public static final String ERROR="error";


    private String status;
    private String message;
    private Object data;

    public AjaxResult(String status,String message){
        this.status=status;
        this.message=message;
    }

    public  AjaxResult(Object data){
        this.status=SUCCESS;
        this.data=data;
    }
}
