package com.sxy.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/22.
 */
public class SerialNumberUtil {

    public static String getSerialNumber(){
        DateTime now=new DateTime();
        String result=now.toString("YYYYMMDDHHmmss");
        result+= RandomStringUtils.randomNumeric(4);
        return result;
    }
}
