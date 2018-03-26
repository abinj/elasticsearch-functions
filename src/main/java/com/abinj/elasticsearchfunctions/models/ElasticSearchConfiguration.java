package com.abinj.elasticsearchfunctions.models;

import java.io.Serializable;

public class ElasticSearchConfiguration implements Serializable{
    private ElasticSearchSettings settings;
    private String server;

    public ElasticSearchSettings getSettings() {
        return settings;
    }

    public void setSettings(ElasticSearchSettings settings) {
        this.settings = settings;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
