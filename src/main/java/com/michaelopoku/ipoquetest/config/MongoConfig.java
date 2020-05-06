package com.michaelopoku.ipoquetest.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public DB mongoClient() {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://admin:abc123!@localhost"));
        return mongoClient.getDB("IpoqueTest");
    }
}