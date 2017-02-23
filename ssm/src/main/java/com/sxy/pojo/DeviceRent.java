package com.sxy.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/2/22.
 */
@Data
public class DeviceRent implements Serializable {
    private Integer id;
    private String companyName;
    private String linkMan;
    private String cardNum;
    private String tel;
    private String address;
    private String fax;
    private String rentDate;
    private String backDate;
    private Integer totalDay;
    private Float totalPrice;
    private Float preCost;
    private Float lastCost;
    private Timestamp creatTime;
    private String creatUser;
    private String serialNumber;
    private String state;

}
