package com.greenfox.exam.badiusosicgreentribes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BadiusOsicGreenTribesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadiusOsicGreenTribesApplication.class, args);
    }

/*
    @Bean
    public TransactionHandlerRegistry handlerRegistry(){
        TransactionHandlerRegistry registry = new TransactionHandlerRegistry();

        registry.add(TransactionType.PRODUCTION, ProductionHandler.class);


        return registry;
    }

 */

}
