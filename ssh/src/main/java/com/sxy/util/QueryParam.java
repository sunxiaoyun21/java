package com.sxy.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class QueryParam {
    private String type;//eq like gt ge;;;
    private String propertyName;
    private Object value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static List<QueryParam> builderQueryparambyRequest(HttpServletRequest request){
        List<QueryParam> paramList= Lists.newArrayList();
        Enumeration<String> paramterNames=request.getParameterNames();
        while (paramterNames.hasMoreElements()){
            String paramterName=paramterNames.nextElement();
            String value=request.getParameter(paramterName);
            if(paramterName.startsWith("q_") && StringUtils.isNotEmpty(value)){

                String[] array=paramterName.split("_",4);
               if(array.length !=4){
                   throw new IllegalArgumentException("查询参数异常");
               }
               Object v=null;
               String dataType=array[2];
                if("d".equalsIgnoreCase(dataType)){
                    v=Double.valueOf(value);
                }else if("f".equalsIgnoreCase(dataType)){
                    v=Float.valueOf(value);
                }else if("l".equalsIgnoreCase(dataType)){
                    v=Long.valueOf(value);
                }else if("i".equalsIgnoreCase(dataType)){
                    v=Integer.valueOf(value);
                }else{
                    try {
                        v=new String(value.getBytes("ISO8859-1"),"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

               QueryParam queryParam=new QueryParam();
               queryParam.setPropertyName(array[3]);
               queryParam.setType(array[1]);
               queryParam.setValue(v);
               paramList.add(queryParam);

               request.setAttribute(paramterName,v);

            }

        }

        return paramList;
    }
}
