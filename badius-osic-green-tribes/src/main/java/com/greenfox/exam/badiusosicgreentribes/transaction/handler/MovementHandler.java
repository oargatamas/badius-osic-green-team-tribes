package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovementHandler implements TransactionHandler<Movement> {
    MovementRepository movementRepository;

    @Override
    public void confirm(Movement transaction) {
        // Todo implement method
    }

    @Override
    public void refund(Movement transaction) {
        // Todo implement method
    }
}
