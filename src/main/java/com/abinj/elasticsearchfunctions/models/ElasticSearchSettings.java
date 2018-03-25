package com.abinj.elasticsearchfunctions.models;

import java.io.Serializable;

public class ElasticSearchSettings implements Serializable{
    private int number_of_shards;
    private int number_of_replicas;

    public int getNumber_of_shards() {
        return number_of_shards;
    }

    public void setNumber_of_shards(int number_of_shards) {
        this.number_of_shards = number_of_shards;
    }

    public int getNumber_of_replicas() {
        return number_of_replicas;
    }

    public void setNumber_of_replicas(int number_of_replicas) {
        this.number_of_replicas = number_of_replicas;
    }
}
