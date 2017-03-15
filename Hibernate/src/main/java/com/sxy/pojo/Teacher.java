package com.sxy.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/14.
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacher;
    @ManyToMany
    @JoinTable(name = "t_student_teacher",
            joinColumns = @JoinColumn(name = "teacherid"),
            inverseJoinColumns = @JoinColumn(name = "stuid")

    )
    private Set<Students> studentsSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Set<Students> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Students> studentsSet) {
        this.studentsSet = studentsSet;
    }
}
