package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import org.springframework.stereotype.Component;

@Component
public class MovementHandler implements TransactionHandler<Movement> {
    MovementRepository movementRepository;
    public MovementHandler(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public void confirm(Movement transaction) {
        // Todo implement method
    }
}
