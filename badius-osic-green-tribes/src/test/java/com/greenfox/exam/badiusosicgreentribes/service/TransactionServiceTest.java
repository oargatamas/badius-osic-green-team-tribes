package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.*;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.UpgradeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    TransactionHandlerFactory handlerFactory;

    @Mock
    TransactionRepository repository;

    @Mock
    MovementHandler movementHandler;

    @Mock
    UpgradeHandler upgradeHandler;

    @Mock
    ProductionHandler productionHandler;

    @InjectMocks
    TransactionService transactionService;

    /*
    public static final long SCHEDULED_MOVEMENT_ID = 1L;
    public static final long EXPIRED_MOVEMENT_ID = 2L;
    public static final long SCHEDULED_UPGRADE_ID = 3L;
    public static final long EXPIRED_UPGRADE_ID = 4L;
    public static final long SCHEDULED_PRODUCTION_ID = 5L;
    public static final long EXPIRED_PRODUCTION_ID = 6L;
     */


    Movement scheduledMovement;
    Movement expiredMovement;
    Transaction scheduledUpgrade;
    Transaction expiredUpgrade;
    Transaction scheduledProduction;
    Transaction expiredProduction;

    public static final int DURATION = 60000;
    public static final LocalDateTime EXPIRED_CREATED_AT = LocalDateTime.now().minusSeconds(DURATION);
    public static final LocalDateTime SCHEDULED_CREATED_AT = LocalDateTime.now();


    @BeforeEach
    void setupMocks() {
        scheduledMovement = getScheduledMovement();
        expiredMovement = getExpiredMovement();
        scheduledUpgrade = getScheduledUpgrade();
        expiredUpgrade = getExpiredUpgrade();
        scheduledProduction = getScheduledProduction();
        expiredProduction = getExpiredProduction();

        /*
        when(repository.findAll()).thenReturn(List.of(
                scheduledMovement,
                expiredMovement,
                scheduledUpgrade,
                expiredUpgrade,
                scheduledProduction,
                expiredProduction
        ));
         */


        /*
        when(repository.findById(SCHEDULED_MOVEMENT_ID)).thenReturn(Optional.of(scheduledMovement));
        when(repository.findById(EXPIRED_MOVEMENT_ID)).thenReturn(Optional.of(expiredMovement));
        when(repository.findById(SCHEDULED_UPGRADE_ID)).thenReturn(Optional.of(scheduledUpgrade));
        when(repository.findById(EXPIRED_UPGRADE_ID)).thenReturn(Optional.of(expiredUpgrade));
        when(repository.findById(SCHEDULED_PRODUCTION_ID)).thenReturn(Optional.of(scheduledProduction));
        when(repository.findById(EXPIRED_PRODUCTION_ID)).thenReturn(Optional.of(expiredProduction));
         */


        lenient().doReturn(movementHandler).when(handlerFactory).getHandler(scheduledMovement);
        lenient().doReturn(movementHandler).when(handlerFactory).getHandler(expiredMovement);
        lenient().doReturn(upgradeHandler).when(handlerFactory).getHandler(scheduledUpgrade);
        lenient().doReturn(upgradeHandler).when(handlerFactory).getHandler(expiredUpgrade);
        lenient().doReturn(productionHandler).when(handlerFactory).getHandler(scheduledProduction);
        lenient().doReturn(productionHandler).when(handlerFactory).getHandler(expiredProduction);
    }


    @Test
    void checkTransactionsWithNoExpiredTransactions() {
        when(repository.findTransactionsByStateIs(TransactionState.SCHEDULED)).thenReturn(List.of(
                scheduledMovement,
                scheduledUpgrade,
                scheduledProduction
        ));

        transactionService.checkTransactions();


        assertEquals(scheduledMovement.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledUpgrade.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledProduction.getState(), TransactionState.SCHEDULED);
        verify(repository, times(1)).findTransactionsByStateIs(TransactionState.SCHEDULED);
        verify(repository, times(0)).save(any());
        verify(handlerFactory, times(0)).getHandler(any());
    }

    @Test
    void checkTransactionsWithExpiredTransactions_AllOk() {
        when(repository.findTransactionsByStateIs(TransactionState.SCHEDULED)).thenReturn(List.of(
                scheduledMovement,
                scheduledUpgrade,
                scheduledProduction,
                expiredMovement,
                expiredUpgrade,
                expiredProduction
        ));

        transactionService.checkTransactions();

        assertEquals(scheduledMovement.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledUpgrade.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledProduction.getState(), TransactionState.SCHEDULED);
        assertEquals(expiredMovement.getState(), TransactionState.COMPLETED);
        assertEquals(expiredUpgrade.getState(), TransactionState.COMPLETED);
        assertEquals(expiredProduction.getState(), TransactionState.COMPLETED);
        verify(repository, times(1)).findTransactionsByStateIs(TransactionState.SCHEDULED);
        verify(repository, times(3)).save(any());
    }

    @Test
    void checkTransactionsWithExpiredTransactions_FailedConfirm() {
        when(repository.findTransactionsByStateIs(TransactionState.SCHEDULED)).thenReturn(List.of(
                scheduledMovement,
                scheduledUpgrade,
                scheduledProduction,
                expiredMovement,
                expiredUpgrade,
                expiredProduction
        ));

        doThrow(RuntimeException.class).when(movementHandler).confirm(expiredMovement);

        transactionService.checkTransactions();


        assertEquals(scheduledMovement.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledUpgrade.getState(), TransactionState.SCHEDULED);
        assertEquals(scheduledProduction.getState(), TransactionState.SCHEDULED);
        assertEquals(expiredMovement.getState(), TransactionState.FAILED);
        assertEquals(expiredUpgrade.getState(), TransactionState.COMPLETED);
        assertEquals(expiredProduction.getState(), TransactionState.COMPLETED);
        verify(repository, times(1)).findTransactionsByStateIs(TransactionState.SCHEDULED);
        verify(repository, times(3)).save(any());
    }


    private Movement getScheduledMovement() {
        return new Movement.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Movement getExpiredMovement() {
        return new Movement.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Upgrade getScheduledUpgrade() {
        return new Upgrade.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Upgrade getExpiredUpgrade() {
        return new Upgrade.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Production getScheduledProduction() {
        return new Production.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Production getExpiredProduction() {
        return new Production.Builder()
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

}