package com.product.catalog.wms.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.Document;

import com.product.catalog.wms.dao.ProductRepository;
import com.product.catalog.wms.dto.Product;

public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() throws InterruptedException, ExecutionException {
        List<Document> productsInDB = productRepository.findAll();
         
        List<Product> products = new ArrayList<Product>();
        
        for (Document document : productsInDB) {
            products.add(buildProduct(document));
        }

        return products;
    }
    
    @Override
    public List<Product> insertProducts(List<Product> products) throws InterruptedException, ExecutionException {
    
        productRepository.insert(products);

        return products;
        
    }
    
    private Product buildProduct(Document document) {
        
        Product product = new Product();
        
        product.setBrand(document.get("brand").toString());
        product.setDescription(document.get("description").toString());
        product.setCategories((List<String>)document.get("categories"));
        product.setName(document.get("name").toString());
        product.setPrice(new BigDecimal(document.get("price").toString()));
        product.setSize((List<String>)document.get("size"));
        product.setSku(document.get("sku").toString());
        product.setSpecialPrice(new BigDecimal(document.get("special_price").toString()));
        
        return product;
        
    }

}
