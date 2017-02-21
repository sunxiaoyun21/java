package com.sxy.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/21.
 */
@Data
public class Disk implements Serializable {

    public  static final String File_TYPE="file";
    public  static final String DIRECTORY_TYPE="directory";

    private Integer id;
    private String name;
    private  String sourceName;
    private  Integer fid;
    private  String size;
    private  String creatTime;
    private  String creatUser;
    private String type;
}
