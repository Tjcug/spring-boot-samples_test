package com.basic.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by dell-pc on 2016/1/15.
 */
@Entity
@Table(name = "t_student")
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private  String name;

    @NotNull
    @Column(name = "age")
    private  String age;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = true,targetEntity = Grade.class)
    @JoinColumn(name = "gradeId",nullable = false)
    private Grade grade;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, String age, Grade grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student() {
    }
}
