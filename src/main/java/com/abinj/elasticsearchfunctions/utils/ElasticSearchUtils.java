package com.abinj.elasticsearchfunctions.utils;

import com.abinj.elasticsearchfunctions.application.MainApplication;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class ElasticSearchUtils {
    private String baseUrl;

    public ElasticSearchUtils(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void createIndex(String indexName, Object configuration) {
        String requestUrl = baseUrl + "/" + indexName;
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        UnirestUtil.putDocument(requestUrl, header, configuration);
    }

    public void createDocument(String index, String type, String id, Object body) {
        String requestUrl = baseUrl + "/" + index + "/" + type + "/" + id + "?pretty";
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        UnirestUtil.putDocument(requestUrl, header, body);
    }

    public void searchDocument(String index, String key, String value) {
        String requestUrl = baseUrl+ "/" + index + "/" + "_search" + "?q=" + key + ":" + value + "&pretty";
        UnirestUtil.getDocument(requestUrl);
    }

    public Map<String, Object> createMapping(Object properties, String type) {
        Map<String, Object> property = new HashMap<>();
        property.put("properties", properties);
        Map<String, Object> typeObject = new HashMap<>();
        typeObject.put(type, property);
        return typeObject;
    }
}
