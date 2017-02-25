package com.sxy.pojo;

import lombok.Data;

/**
 * Created by Administrator on 2017/2/23.
 */
@Data
public class Finance {

    public static final String TYPE_IN="收入";
    public static final String TYPE_OUT="支出";
    public static final String STATE_NEW="未确认";
    public static final String STATE_OK="已确认";


    private Integer id;
    private String serialNumber;
    private String type;
    private float money;
    private String state;
    private String module;
    private String createDate;
    private String ceratUser;
    private String confirmUser;
    private String confirmDate;
    private String remark;
    private String moduleSerialNumber;

}
