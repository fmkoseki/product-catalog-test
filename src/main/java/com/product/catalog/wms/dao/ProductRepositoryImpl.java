package com.product.catalog.wms.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.bson.Document;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;
import com.product.catalog.wms.dto.Product;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String COLLECTION = "product";
    
    private MongoDatabase mongoDatabase;
    
    public ProductRepositoryImpl(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @Override
    public List<Document> findAll() throws InterruptedException, ExecutionException {
    
        MongoCollection<Document> productCollection = mongoDatabase.getCollection(
            COLLECTION
        );
        
        CompletableFuture<List<Document>> result = new CompletableFuture<>();
        
        productCollection.find().into(new ArrayList<Document>(),
            new SingleResultCallback<List<Document>>() {
            
                @Override
                public void onResult(List<Document> list, Throwable tr) {
                    result.complete(list);
                }
            
            }
        );
        
        return result.get();
        
    }

    @Override
    public List<Document> insert(List<Product> products) throws InterruptedException, ExecutionException {

        MongoCollection<Document> productCollection = mongoDatabase.getCollection(
            COLLECTION
        );
        
        CompletableFuture<List<Document>> result = new CompletableFuture<>();
        
        List<Document> documents = new ArrayList<Document>();
        
        for (Product product : products) {
            documents.add(convertProductToDocument(product));
        }
        
        productCollection.insertMany(documents,
            new SingleResultCallback<Void>() {
        
                @Override
                public void onResult(Void v, Throwable tr) {
                    
                }
            
            }
        );
        
        return result.get();
        
    }
    
    private Document convertProductToDocument(Product product) {
        Document document = new Document();
        
        document.put("sku", product.getSku());
        document.put("categories", product.getCategories());
        document.put("description", product.getDescription());
        document.put("name", product.getName());
        document.put("price", product.getPrice());
        document.put("size", product.getSize());
        document.put("brand", product.getBrand());
        document.put("special_price", product.getSpecialPrice());
        
        return document;
    }
    
}
