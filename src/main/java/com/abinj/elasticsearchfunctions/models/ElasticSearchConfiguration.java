package com.abinj.elasticsearchfunctions.models;

import java.io.Serializable;

public class ElasticSearchConfiguration implements Serializable{
    private ElasticSearchSettings settings;

    public ElasticSearchSettings getSettings() {
        return settings;
    }

    public void setSettings(ElasticSearchSettings settings) {
        this.settings = settings;
    }
}
