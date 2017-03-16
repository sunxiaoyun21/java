package com.sxy.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/16.
 */
@Entity
@Table
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
