package com.abinj.elasticsearchfunctions.models;

public class Department {
    private String departmentName;
    private String language;

    public Department(String departmentName, String language) {
        this.departmentName = departmentName;
        this.language = language;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
