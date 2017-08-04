package com.product.catalog.wms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.async.client.MongoDatabase;
import com.product.catalog.wms.dao.ProductRepository;
import com.product.catalog.wms.dao.ProductRepositoryImpl;
import com.product.catalog.wms.service.ProductService;
import com.product.catalog.wms.service.ProductServiceImpl;

@Configuration
public class WMSConfig {

    @Bean
    public ProductRepository productRepository(MongoDatabase mongoDatabase) {
        return new ProductRepositoryImpl(mongoDatabase);
    }
    
    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
    
}
