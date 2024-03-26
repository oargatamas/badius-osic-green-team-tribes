package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import org.springframework.stereotype.Component;

@Component
public class ProductionHandler implements TransactionHandler<Production>{
    @Override
    public void confirm(Production transaction) {
        // Todo implement method
    }
}
