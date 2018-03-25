package com.abinj.elasticsearchfunctions.models.properties;

import java.io.Serializable;

public class EmployeeProperty implements Serializable{
    private PropertyItem name;
    private PropertyItem age;

    public EmployeeProperty(PropertyItem name, PropertyItem age) {
        this.name = name;
        this.age = age;
    }

    public PropertyItem getName() {
        return name;
    }

    public void setName(PropertyItem name) {
        this.name = name;
    }

    public PropertyItem getAge() {
        return age;
    }

    public void setAge(PropertyItem age) {
        this.age = age;
    }
}
