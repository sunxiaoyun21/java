package com.sxy.test;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/12/8.
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        Document document= Jsoup.connect("http://www.topit.me/")
                .cookie("is_click","1")
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                .get();

        Elements elements=document.select("#content .e>a");
            String href=elements.attr("href");

          for (int i=0;i<elements.size();i++){
              Document bigdocument=Jsoup.connect(href)
                      .cookie("is_click","1")
                      .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                      .get();
              Element img=bigdocument.select("#content #item-tip img").first();
              String imgsrc=img.attr("src");

              CloseableHttpClient httpClient= HttpClients.createDefault();
              HttpGet httpGet=new HttpGet(imgsrc);
              HttpResponse response=httpClient.execute(httpGet);

              if(response.getStatusLine().getStatusCode()==200){
                  InputStream inputStream=response.getEntity().getContent();
                  String imgname=imgsrc.substring(imgsrc.lastIndexOf("/"));
                  OutputStream outputStream=new FileOutputStream("E:/top/"+imgname);
                  IOUtils.copy(inputStream,outputStream);
                  outputStream.flush();
                  outputStream.close();
                  inputStream.close();
              }else {
                  System.out.println("ERROR"+response.getStatusLine().getStatusCode());
              }
          }


    }
}
