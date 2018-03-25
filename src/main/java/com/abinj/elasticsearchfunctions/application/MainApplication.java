package com.abinj.elasticsearchfunctions.application;

import com.abinj.elasticsearchfunctions.models.Employee;
import com.abinj.elasticsearchfunctions.utils.ElasticSearchUtils;

public class MainApplication {
    private static ElasticSearchUtils elasticSearchUtils = new ElasticSearchUtils("http://localhost:9200");

    public static void main(String[] args) {

        elasticSearchUtils.createDocument("employee", "_doc", "1", new Employee("Arun", "25"));

        //Search Query String as a Parameter
        elasticSearchUtils.searchDocument("employee", "name", "Arun");
    }

}
