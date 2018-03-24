package com.abinj.elasticsearchfunctions.utils;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.util.Map;
import java.util.concurrent.Future;

public class UnirestUtil {
    private static final Gson gson = new Gson();

    public static void putDocument(String url, Map<String, String> headers, Object body) {
        HttpRequestWithBody httpRequestWithBody = Unirest.put(url);
        headers.forEach(httpRequestWithBody::header);
        httpRequestWithBody.body(gson.toJson(body));
        Future<HttpResponse<JsonNode>> future = httpRequestWithBody
                .asJsonAsync(new Callback<JsonNode>() {

                    public void failed(UnirestException e) {
                        System.out.println(e.getMessage());
                    }

                    public void completed(HttpResponse<JsonNode> response) {
                        System.out.println(response.getBody());
                    }

                    public void cancelled() {
                        System.out.println("API Cancelled");
                    }
                });
    }
}
