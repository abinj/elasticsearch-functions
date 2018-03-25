package com.abinj.elasticsearchfunctions.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexConfiguration {
    private ElasticSearchSettings settings;
    private Map<String, Object> mappings;


    public Map<String, Object> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, Object> mappings) {
        this.mappings = mappings;
    }

    public ElasticSearchSettings getSettings() {
        return settings;
    }

    public void setSettings(ElasticSearchSettings settings) {
        this.settings = settings;
    }
}
