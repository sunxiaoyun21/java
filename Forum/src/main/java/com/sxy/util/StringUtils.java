package com.sxy.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/12/16.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 将ISO8859-1转换为UTF-8字符串
     * @param str
     * @return
     */
    public static String toUtf8(String str){
        try {
            return new String(str.getBytes("ISO8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("字符串"+str+"转换异常",e);
        }

    }
}
