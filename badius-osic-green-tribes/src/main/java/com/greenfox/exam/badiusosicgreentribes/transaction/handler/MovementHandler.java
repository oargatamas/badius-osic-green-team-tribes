package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import org.springframework.stereotype.Component;

@Component
public class MovementHandler implements TransactionHandler<Movement> {
    @Override
    public void confirm(Movement transaction) {
        // Todo implement method
    }
}
