package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleService;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.exception.TransactionRefundNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovementHandler implements TransactionHandler<Movement> {

    MovementRepository movementRepository;
    BattleService battleService;
    KingdomRepository kingdomRepository;

    @Override
    public void confirm(Movement transaction) {
        if (!transaction.getOrigin().getOwner().equals(transaction.getDestination().getOwner())) {
            battleService.startBattle(transaction);
        } else {
            transaction.getOrigin().getStorage().getArmies().remove(transaction.getArmy());
            transaction.getDestination().getStorage().getArmies().add(transaction.getArmy());

            kingdomRepository.saveAll(List.of(transaction.getOrigin(), transaction.getDestination()));
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
