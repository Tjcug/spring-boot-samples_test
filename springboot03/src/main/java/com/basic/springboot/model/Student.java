package com.basic.springboot.model;

/**
 * Created by dell-pc on 2016/4/19.
 */
public class Student {
    private  String name;
    private  int id;
    private  String username;

    public Student(String name, int id,String username) {
        this.name = name;
        this.id = id;
        this.username=username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
