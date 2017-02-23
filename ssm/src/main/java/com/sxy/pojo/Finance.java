package com.sxy.pojo;

import lombok.Data;

/**
 * Created by Administrator on 2017/2/23.
 */
@Data
public class Finance {

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

}
