package com.sxy.pojo;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/3/14.
 */
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GenericGenerator(name = "fk",strategy = "foreign",parameters = {
            @Parameter(name = "property",value = "person")
    })
    @GeneratedValue(generator = "fk")
    private Integer id;
    private Integer num;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
