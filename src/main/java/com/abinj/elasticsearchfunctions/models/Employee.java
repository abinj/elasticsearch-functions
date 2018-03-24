package com.abinj.elasticsearchfunctions.models;

import java.io.Serializable;

public class Employee implements Serializable{
    private String name;
    private String age;

    public Employee(String name, String age) {
        this.name = name;
        this.age = age;
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
}
