package com.product.catalog.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.product.catalog.wms"})
public class Application {

    Application(){
        // default constructor
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
