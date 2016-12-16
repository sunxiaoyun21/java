package com.sxy.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/12/16.
 */
public class Config {
    private static Properties prop=new Properties();

    static {
        try {
            prop.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取config.properties文件异常",e);
        }

    }

    public static String get(String key){
        return  prop.getProperty(key);
    }
}
