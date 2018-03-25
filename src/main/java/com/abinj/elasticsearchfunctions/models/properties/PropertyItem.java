package com.abinj.elasticsearchfunctions.models.properties;

public class PropertyItem {
    private String type = "text";

    public PropertyItem(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
