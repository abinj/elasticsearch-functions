package com.abinj.elasticsearchfunctions.utils;

import java.util.HashMap;
import java.util.Map;


public class ElasticSearchUtils {
    private String baseUrl;

    public ElasticSearchUtils(String baseUrl) {
        this.baseUrl = baseUrl;
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
}
