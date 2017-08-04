package com.product.catalog.wms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;
@Configuration
public class MongoConfig {
    
    private static final String URI = "mongodb://localhost:27017";
    
    private static final String DATABASE = "wms";
    
    @Bean
    public MongoDatabase mongoDatabase() {
        
        MongoClient asyncClient = MongoClients.create(new ConnectionString(URI));
        
        return asyncClient.getDatabase(DATABASE); 
        
    }

}
