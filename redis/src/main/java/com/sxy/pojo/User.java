package com.sxy.pojo;


public class User {

    private Integer id;
    private String userName;
    private float score;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String userName, float score) {
        this.userName = userName;
        this.score = score;
    }

    public User(Integer id, String userName, float score) {
        this.id = id;
        this.userName = userName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
