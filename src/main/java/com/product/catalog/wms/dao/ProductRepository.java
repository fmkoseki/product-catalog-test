package com.product.catalog.wms.dao;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.bson.Document;

import com.product.catalog.wms.dto.Product;

public interface ProductRepository {

    public List<Document> findAll() throws InterruptedException, ExecutionException;
    
    public List<Document> insert(List<Product> products) throws InterruptedException, ExecutionException;
    
}
