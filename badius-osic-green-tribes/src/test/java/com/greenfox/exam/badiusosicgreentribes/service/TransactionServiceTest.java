package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.*;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.UpgradeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    Movement scheduledMovement;
    Movement expiredMovement;
    Upgrade scheduledUpgrade;
    Upgrade expiredUpgrade;
    Production scheduledProduction;
    Production expiredProduction;

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

        lenient().doReturn(movementHandler).when(handlerFactory).getHandler(TransactionType.MOVEMENT);
        lenient().doReturn(upgradeHandler).when(handlerFactory).getHandler(TransactionType.UPGRADE);
        lenient().doReturn(productionHandler).when(handlerFactory).getHandler(TransactionType.PRODUCTION);
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

    @Test
    void cancelTransactions_AllScheduled() {
        List<Long> trxIds = List.of(1L, 2L, 3L);
        List<Transaction> scheduledTransactions = List.of(
                scheduledMovement,
                scheduledUpgrade,
                scheduledProduction
        );
        when(repository.findTransactionsByIdInAndState(trxIds, TransactionState.SCHEDULED)).thenReturn(scheduledTransactions);

        transactionService.cancelTransactions(trxIds);

        for (Transaction transaction : scheduledTransactions) {
            assertEquals(TransactionState.CANCELLED, transaction.getState());
        }

        verify(handlerFactory, times(1)).getHandler(TransactionType.PRODUCTION);
        verify(handlerFactory, times(1)).getHandler(TransactionType.MOVEMENT);
        verify(handlerFactory, times(1)).getHandler(TransactionType.UPGRADE);
        verify(movementHandler, times(1)).refund(scheduledMovement);
        verify(upgradeHandler, times(1)).refund(scheduledUpgrade);
        verify(productionHandler, times(1)).refund(scheduledProduction);
        verify(repository, times(3)).save(any());
    }

    @Test
    void cancelTransactions_FailedCancellation() {
        List<Long> trxIds = List.of(1L, 2L, 3L);
        List<Transaction> scheduledTransactions = List.of(
                scheduledMovement,
                scheduledUpgrade,
                scheduledProduction
        );
        when(repository.findTransactionsByIdInAndState(trxIds, TransactionState.SCHEDULED)).thenReturn(scheduledTransactions);

        doThrow(RuntimeException.class).when(movementHandler).refund(any());

        transactionService.cancelTransactions(trxIds);

        assertEquals(TransactionState.SCHEDULED, scheduledMovement.getState());
        assertEquals(TransactionState.CANCELLED, scheduledProduction.getState());
        assertEquals(TransactionState.CANCELLED, scheduledUpgrade.getState());
        verify(handlerFactory, times(1)).getHandler(TransactionType.PRODUCTION);
        verify(handlerFactory, times(1)).getHandler(TransactionType.MOVEMENT);
        verify(handlerFactory, times(1)).getHandler(TransactionType.UPGRADE);
        verify(movementHandler, times(1)).refund(scheduledMovement);
        verify(upgradeHandler, times(1)).refund(scheduledUpgrade);
        verify(productionHandler, times(1)).refund(scheduledProduction);
        verify(repository, times(2)).save(any());
    }

    @Test
    void cancelTransaction_Scheduled() {
        Long trxId = 1L;
        when(repository.findTransactionByIdAndState(trxId, TransactionState.SCHEDULED)).thenReturn(scheduledUpgrade);

        transactionService.cancelTransaction(trxId);

        assertEquals(TransactionState.CANCELLED, scheduledUpgrade.getState());
        verify(handlerFactory, times(1)).getHandler(TransactionType.UPGRADE);
        verify(upgradeHandler, times(1)).refund(scheduledUpgrade);
        verify(repository, times(1)).save(any());
    }

    @Test
    void cancelTransaction_FailedCancellation() {
        Long trxId = 1L;
        when(repository.findTransactionByIdAndState(trxId, TransactionState.SCHEDULED)).thenReturn(scheduledMovement);
        doThrow(RuntimeException.class).when(movementHandler).refund(any());

        transactionService.cancelTransaction(trxId);

        assertEquals(TransactionState.SCHEDULED, scheduledMovement.getState());
        verify(handlerFactory, times(1)).getHandler(TransactionType.MOVEMENT);
        verify(movementHandler, times(1)).refund(scheduledMovement);
        verify(repository, times(0)).save(any());
    }

    private Movement getScheduledMovement() {
        return Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Movement getExpiredMovement() {
        return Movement.builder()
                .transactionType(TransactionType.MOVEMENT)
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Upgrade getScheduledUpgrade() {
        return Upgrade.builder()
                .transactionType(TransactionType.UPGRADE)
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Upgrade getExpiredUpgrade() {
        return Upgrade.builder()
                .transactionType(TransactionType.UPGRADE)
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Production getScheduledProduction() {
        return Production.builder()
                .transactionType(TransactionType.PRODUCTION)
                .state(TransactionState.SCHEDULED)
                .startAt(SCHEDULED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

    private Production getExpiredProduction() {
        return Production.builder()
                .transactionType(TransactionType.PRODUCTION)
                .state(TransactionState.SCHEDULED)
                .startAt(EXPIRED_CREATED_AT)
                .duration(DURATION)
                .build();
    }

}
