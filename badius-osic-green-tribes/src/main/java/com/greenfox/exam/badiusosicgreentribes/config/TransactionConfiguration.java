package com.greenfox.exam.badiusosicgreentribes.config;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.UpgradeHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TransactionConfiguration {

    @Bean
    public TransactionHandlerRegistry handlerRegistry(){
        TransactionHandlerRegistry registry = new TransactionHandlerRegistry();

        registry.add(TransactionType.PRODUCTION, ProductionHandler.class);
        registry.add(TransactionType.MOVEMENT, MovementHandler.class);
        registry.add(TransactionType.UPGRADE, UpgradeHandler.class);

        return registry;
    }
}
