package com.product.catalog.wms.web;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.catalog.wms.dto.Product;
import com.product.catalog.wms.service.ProductService;

@RestController
@RequestMapping("/api")
public class WMSController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts() throws InterruptedException, ExecutionException {
        
        return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);
		
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<List<Product>> createProducts(@RequestBody List<Product> products)
        throws InterruptedException, ExecutionException {
        
        return new ResponseEntity<List<Product>>(productService.insertProducts(products), HttpStatus.OK);
        
    }
    

}
