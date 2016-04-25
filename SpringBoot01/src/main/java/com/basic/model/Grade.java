package com.basic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by dell-pc on 2016/1/16.
 */
@Entity
@Table(name = "t_grade")
public class Grade  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String classname;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "grade")
    private transient Set<Student> studentSet;
    public Grade(String classname) {
        this.classname = classname;
    }

    public Grade() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
