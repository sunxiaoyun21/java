package com.sxy.test;



import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/12/6.
 */
public class Test  {
    public static void main(String[] args) throws IOException {
        //创建了一个可以发出请求的客户端
        CloseableHttpClient httpClient=HttpClients.createDefault();
        //创建一个GET请求
        HttpGet httpGet=new HttpGet("http://www.kaishengit.com");
        //发出请求并接受服务端的响应
       HttpResponse response= httpClient.execute(httpGet);
       if(response.getStatusLine().getStatusCode()==200){
           //响应输入流
           InputStream inputStream=response.getEntity().getContent();
           String result=IOUtils.toString(inputStream,"UTF-8");
           inputStream.close();
           System.out.println(result);

       }else {
           System.out.println("服务端异常"+response.getStatusLine().getStatusCode());
       }
       httpClient.close();
    }
}
