package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleService;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MovementHandler implements TransactionHandler<Movement> {

    MovementRepository movementRepository;
    BattleService battleService;
    TransactionHandlerFactory handlerFactory;

    @Override
    public void confirm(Movement transaction) {
        if (!transaction.getOrigin().getOwner().equals(transaction.getDestination().getOwner())) {
            battleService.startBattle(transaction);
        } else {
            //Todo remove army from the origin kingdom's storage
            transaction.getDestination().getStorage().add(transaction.getArmy());
            //Todo call save on Kingdom repositories
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

            //Todo remove and do not confirm the transaction here. Instead call the repository save on the refundMovement!!!
            TransactionHandler refundHandler = handlerFactory.getHandler(refundMovement.getTransactionType());
            refundHandler.confirm(refundMovement);
        } else {
            throw new RuntimeException("This Movement transaction is not refundable"); // Todo create and throw customException here (e.g.: TransactionRefundNotAllowed )
        }
    }

    //Todo remove this method as it is not in use
    private boolean isTransactionExpired(LocalDateTime startedAt, Integer durationInSeconds, LocalDateTime currentTime) {
        LocalDateTime expirationTime = startedAt.plusSeconds(durationInSeconds);
        return expirationTime.isBefore(currentTime);
    }
}
