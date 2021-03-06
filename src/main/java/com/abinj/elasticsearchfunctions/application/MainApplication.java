package com.abinj.elasticsearchfunctions.application;

import com.abinj.elasticsearchfunctions.models.ElasticSearchConfiguration;
import com.abinj.elasticsearchfunctions.models.Employee;
import com.abinj.elasticsearchfunctions.models.IndexConfiguration;
import com.abinj.elasticsearchfunctions.models.properties.EmployeeProperty;
import com.abinj.elasticsearchfunctions.models.properties.PropertyItem;
import com.abinj.elasticsearchfunctions.utils.ElasticSearchUtils;
import com.abinj.elasticsearchfunctions.utils.UnirestUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class MainApplication {
    private static ElasticSearchUtils elasticSearchUtils = new ElasticSearchUtils("http://localhost:9200");
    private static ElasticSearchConfiguration configuration;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Argument missing: <Conf file path>");
            return;
        }
        buildConfiguration(args[0]);

        indexAPIS();

        documentAPIs();

        searchAPIs();
    }

    private static void searchAPIs() {
        //Search Query, String as a Parameter
        elasticSearchUtils.searchDocument("employee", "name", "abin");

        //Search Query, within specific types
        elasticSearchUtils.searchDocument("employee/junior", "name", "Abin");

        //Search across all available indices
        elasticSearchUtils.searchDocument("_all", "name", "abin");
    }

    private static void documentAPIs() {
        //Crete document within an indices
        elasticSearchUtils.createDocument("employee", "junior", "1", new Employee("Abin", "25"));
    }

    private static void indexAPIS() {
        //Create index with settings
        IndexConfiguration indexConfiguration = new IndexConfiguration();
        indexConfiguration.setSettings(configuration.getSettings());
        elasticSearchUtils.createIndex("ecommerce", indexConfiguration);

        //Create index with settings and mapping
        EmployeeProperty employeeProperty = new EmployeeProperty(new PropertyItem("text")
                , new PropertyItem("text"));
        Map<String, Object> mappings = elasticSearchUtils.createMapping(employeeProperty, "junior");
        indexConfiguration.setMappings(mappings);
        elasticSearchUtils.createIndex("employee", indexConfiguration);

        //Get index
        UnirestUtil.get(configuration.getServer() + "/" + "employee" + "?pretty");

        //Get all indices
        UnirestUtil.get(configuration.getServer() + "/_all?pretty");

        //Check index exists(response code = 200 if index exists, else 404)
        UnirestUtil.head(configuration.getServer() + "/employee?pretty");

        //Delete index
        UnirestUtil.delete(configuration.getServer() + "/ecommerce");
    }

    private static void buildConfiguration(String filePath) {
        Yaml yaml =new Yaml();
        String yamlFilePath = filePath;

        try {
            InputStream yamlInputStream = new FileInputStream(yamlFilePath);
            configuration = yaml.loadAs(yamlInputStream, ElasticSearchConfiguration.class);
        } catch (FileNotFoundException e) {
            System.out.println("Yaml file not found!!!");
        }
    }

    public static void setConfiguration(ElasticSearchConfiguration configuration) {
        MainApplication.configuration = configuration;
    }

    public static ElasticSearchConfiguration getConfiguration() {
        return configuration;
    }

}
