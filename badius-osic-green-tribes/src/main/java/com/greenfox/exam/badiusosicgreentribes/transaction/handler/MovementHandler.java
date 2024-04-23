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

    public MovementHandler(MovementRepository movementRepository, BattleService battleService, TransactionHandlerFactory handlerFactory) {
        this.movementRepository = movementRepository;
        this.battleService = battleService;
        this.handlerFactory = handlerFactory;
    }

    @Override
    public void confirm(Movement transaction) {

        if (isTransactionExpired(transaction.getStartAt(), transaction.getDuration(), LocalDateTime.now())) {
            if (!transaction.getOrigin().getOwner().equals(transaction.getDestination().getOwner())) {
                battleService.startBattle(transaction);
            } else {
                transaction.getDestination().getStorage().add(transaction.getArmy());
            }
        }
    }

    @Override
    public void refund(Movement transaction) {
        if (transaction.isRefundable()) {
            Movement refundMovement = Movement.builder()
                    .transactionType(TransactionType.MOVEMENT)
                    .state(TransactionState.SCHEDULED)
                    .startAt(LocalDateTime.now())
                    .duration(transaction.getDuration())
                    .destination(transaction.getOrigin())
                    .army(transaction.getArmy())
                    .build();
            TransactionHandler refundHandler = handlerFactory.getHandler(refundMovement.getTransactionType());
            refundHandler.confirm(refundMovement);
        } else {
            throw new RuntimeException("This Movement transaction is not refundable");
        }
    }

    private boolean isTransactionExpired(LocalDateTime startedAt, Integer durationInSeconds, LocalDateTime currentTime) {
        LocalDateTime expirationTime = startedAt.plusSeconds(durationInSeconds);
        return expirationTime.isBefore(currentTime);
    }
}
