package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleService;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.exception.TransactionRefundNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MovementHandler implements TransactionHandler<Movement> {

    MovementRepository movementRepository;
    BattleService battleService;
    TransactionHandlerFactory handlerFactory;
    KingdomRepository kingdomRepository;

    @Override
    public void confirm(Movement transaction) {
        if (!transaction.getOrigin().getOwner().equals(transaction.getDestination().getOwner())) {
            battleService.startBattle(transaction);
        } else {
            transaction.getOrigin().getStorage().delete(transaction.getArmy());
            transaction.getDestination().getStorage().add(transaction.getArmy());
            kingdomRepository.save(transaction.getOrigin());
            kingdomRepository.save(transaction.getDestination());
        }
    }

    @Override
    public void refund(Movement transaction) {
        if (transaction.getRefundable()) {
            Movement refundMovement = Movement.builder()
                    .transactionType(TransactionType.MOVEMENT)
                    .state(TransactionState.SCHEDULED)
                    .startAt(LocalDateTime.now())
                    .duration(transaction.getDuration())
                    .destination(transaction.getOrigin())
                    .army(transaction.getArmy())
                    .build();
            movementRepository.save(refundMovement);
        } else {
            throw new TransactionRefundNotAllowedException(transaction);
        }
    }
}
