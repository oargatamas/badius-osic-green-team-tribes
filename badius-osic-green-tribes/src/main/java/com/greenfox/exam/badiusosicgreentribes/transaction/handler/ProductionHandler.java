package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.ProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductionHandler implements TransactionHandler<Production>{

    ProductionRepository productionRepository;

    @Override
    public void confirm(Production transaction) {
        // Todo implement method
    }

    @Override
    public void refund(Production transaction) {
        // Todo implement method
    }
}
