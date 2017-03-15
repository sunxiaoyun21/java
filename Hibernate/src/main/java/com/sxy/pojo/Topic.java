package com.sxy.pojo;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Topic {

    private Integer id;
    private String title;
    private Content content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
