package com.product.catalog.wms.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.product.catalog.wms.dto.Product;

public interface ProductService {

    public List<Product> getProducts() throws InterruptedException, ExecutionException;
    
    public List<Product> insertProducts(List<Product> products) throws InterruptedException, ExecutionException;
    
}
