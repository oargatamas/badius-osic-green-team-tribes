package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.ProductionRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductionHandler implements TransactionHandler<Production>{

    ProductionRepository productionRepository;

    public ProductionHandler(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public void confirm(Production transaction) {
        // Todo implement method
    }
}
