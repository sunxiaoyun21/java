package com.sxy.pojo;

import java.util.Set;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Teacher {

    private Integer id;
    private String teacher;
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
