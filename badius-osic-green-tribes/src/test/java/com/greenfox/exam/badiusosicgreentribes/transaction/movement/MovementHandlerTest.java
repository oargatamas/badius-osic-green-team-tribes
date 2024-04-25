package com.greenfox.exam.badiusosicgreentribes.transaction.movement;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Storage;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleService;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.exception.TransactionRefundNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovementHandlerTest {

    @Mock
    MovementRepository movementRepository;
    @Mock
    BattleService battleService;
    @Mock
    KingdomRepository kingdomRepository;
    @InjectMocks
    MovementHandler movementHandler;

    Movement movementWithBetweenAlliedKingdoms;
    Movement movementWithTowardsEnemy;
    Movement cancelledMovementResultMovement;

    User owner1, owner2;
    Kingdom origin, alliedDestination, enemyDestination;
    Army movingArmy, defenderArmy;

    @BeforeEach
    void setupMocks() {
        owner1 = User.builder().userId(12L).build();
        owner2 = User.builder().userId(1L).build();

        movingArmy = Army.builder()
                .build();

        defenderArmy = Army.builder()
                .build();

        origin = Kingdom.builder()
                .owner(owner1)
                .storage(Storage.builder()
                        .food(70)
                        .gold(220)
                        .defenderArmy(Army.builder().build())
                        .armies(new ArrayList<>(List.of(movingArmy)))
                        .buildings(new ArrayList<>())
                        .build())
                .build();

        alliedDestination = Kingdom.builder()
                .owner(owner1)
                .storage(Storage.builder()
                        .food(90)
                        .gold(250)
                        .defenderArmy(Army.builder().build())
                        .armies(new ArrayList<>())
                        .buildings(new ArrayList<>())
                        .build())
                .build();

        enemyDestination = Kingdom.builder()
                .owner(owner2)
                .storage(Storage.builder()
                        .food(90)
                        .gold(250)
                        .defenderArmy(defenderArmy)
                        .armies(new ArrayList<>())
                        .buildings(new ArrayList<>())
                        .build())
                .build();

        movementWithBetweenAlliedKingdoms = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(alliedDestination)
                .army(movingArmy)
                .refundable(true)
                .build();

        movementWithTowardsEnemy = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(enemyDestination)
                .army(movingArmy)
                .refundable(true)
                .build();

        cancelledMovementResultMovement = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(origin)
                .army(movingArmy)
                .refundable(false)
                .build();
    }

    @Test
    void confirmMovementWithBetweenAlliedKingdoms() {
        //Act
        movementHandler.confirm(movementWithBetweenAlliedKingdoms);
        //Assert
        verify(kingdomRepository, times(1)).saveAll(anyList());

        //Todo assert on the kingdom entities to verify the army transfer
    }

    @Test
    void confirmMovementWithTowardsEnemy() {
        //Act
        movementHandler.confirm(movementWithTowardsEnemy);
        //Assert
        verify(battleService, times(1)).startBattle(movementWithTowardsEnemy);
    }

    @Test
    void confirmCancelledMovementResultMovement() {
        //Act
        movementHandler.confirm(cancelledMovementResultMovement);
        //Assert
        verify(kingdomRepository, times(1)).saveAll(anyList());

        //Todo assert on the kingdom entities to verify the army transfer cancel
    }

    @Test
    void refundMovementWithBetweenAlliedKingdoms() {
        //Arrange
        Movement expectedRefundMovement = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(any(LocalDateTime.class))
                .duration(60000)
                .destination(origin)
                .army(movingArmy)
                .build();

        //Act
        movementHandler.refund(movementWithBetweenAlliedKingdoms);
        //Assert
        verify(movementRepository, times(1)).save(expectedRefundMovement);
    }

    @Test
    void refundMovementWithTowardsEnemy() {
        //Arrange
        Movement expectedRefundMovement = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(any(LocalDateTime.class))
                .duration(60000)
                .destination(origin)
                .army(movingArmy)
                .build();
        //Act
        movementHandler.refund(movementWithTowardsEnemy);
        //Assert
        verify(movementRepository, times(1)).save(expectedRefundMovement);
    }

    @Test
    void refundCancelledMovementResultMovement() {
        //Act
        assertThrows(TransactionRefundNotAllowedException.class, () -> movementHandler.refund(cancelledMovementResultMovement));
    }
}
