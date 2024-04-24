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

    Movement movementWithSameOriginAndDestination;
    Movement movementWithDifferentOriginAndDestination;
    Movement movementWithSameOriginAndDestinationNotRefundable;
    Kingdom origin;
    Kingdom destination;
    Army army1;
    Army army2;

    @BeforeEach
    void setupMocks() {

        origin = Kingdom.builder()
                .owner(new User())
                .storage(new Storage(70, 220, army1, new ArrayList<>(), new ArrayList<>()))
                .build();
        destination = Kingdom.builder()
                .owner(new User())
                .storage(new Storage(90, 250, army2, new ArrayList<>(), new ArrayList<>()))
                .build();
        army1 = Army.builder()
                .build();
        army2 = Army.builder()
                .build();

        movementWithDifferentOriginAndDestination = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(destination)
                .army(army1)
                .build();

        movementWithSameOriginAndDestination = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(origin)
                .army(army1)
                .refundable(true)
                .build();

        movementWithSameOriginAndDestinationNotRefundable = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(LocalDateTime.now())
                .duration(60000)
                .origin(origin)
                .destination(origin)
                .army(army1)
                .refundable(false)
                .build();
    }

    @Test
    void confirmMovementWithDifferentOriginAndDestination() {
        //Act
        movementHandler.confirm(movementWithDifferentOriginAndDestination);
        //Assert
        verify(battleService, times(1)).startBattle(movementWithDifferentOriginAndDestination);
    }

    @Test
    void confirmMovementWithSameOriginAndDestination() {
        //Act
        movementHandler.confirm(movementWithSameOriginAndDestination);
        //Assert
        verify(kingdomRepository, times(1)).saveAll(anyList());
    }

    @Test
    void refundMovementRefundAllowed() {
        //Arrange
        Movement expectedRefundMovement = Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(any(LocalDateTime.class))
                .duration(60000)
                .destination(origin)
                .army(army1)
                .build();
        //Act
        movementHandler.refund(movementWithSameOriginAndDestination);
        //Assert
        verify(movementRepository, times(1)).save(expectedRefundMovement);
    }

    @Test
    void refundMovementRefundNotAllowed() {
        //Act and Assert
        assertThrows(TransactionRefundNotAllowedException.class, () -> movementHandler.refund(movementWithSameOriginAndDestinationNotRefundable));
    }
}
