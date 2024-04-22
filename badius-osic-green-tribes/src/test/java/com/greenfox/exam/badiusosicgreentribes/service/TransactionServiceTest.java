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
                getScheduledMovement(),
                getScheduledUpgrade(),
                getScheduledProduction()
        );
        when(repository.findTransactionsByIdInAndState(trxIds, TransactionState.SCHEDULED)).thenReturn(scheduledTransactions);

        transactionService.cancelTransactions(trxIds);

        for (Transaction transaction : scheduledTransactions) {
            assertEquals(TransactionState.CANCELLED, transaction.getState());
        }
        verify(repository, times(scheduledTransactions.size())).save(any());
        verify(handlerFactory, times(scheduledTransactions.size())).getHandler(any());
    }

    @Test
    void cancelTransactions_FailedCancellation() {
        List<Long> trxIds = List.of(1L, 2L, 3L);
        List<Transaction> scheduledTransactions = List.of(
                getScheduledMovement(),
                getScheduledUpgrade(),
                getScheduledProduction()
        );
        when(repository.findTransactionsByIdInAndState(trxIds, TransactionState.SCHEDULED)).thenReturn(scheduledTransactions);

        doThrow(RuntimeException.class).when(movementHandler).refund(any());

        transactionService.cancelTransactions(trxIds);

        for (Transaction transaction : scheduledTransactions) {
            if (transaction.getTransactionType() == TransactionType.MOVEMENT) {
                assertEquals(TransactionState.CANCELLED, transaction.getState());
                assertThrows(RuntimeException.class, () -> movementHandler.refund((Movement) transaction));
                verify(movementHandler, times(2)).refund((Movement) transaction);
            } else if (transaction.getTransactionType() == TransactionType.UPGRADE) {
                assertEquals(TransactionState.CANCELLED, transaction.getState());
                verify(handlerFactory, times(1)).getHandler(transaction.getTransactionType());
                verify(upgradeHandler, times(1)).refund((Upgrade) transaction);
            } else {
                assertEquals(TransactionState.CANCELLED, transaction.getState());
                verify(handlerFactory, times(1)).getHandler(transaction.getTransactionType());
                verify(productionHandler, times(1)).refund((Production) transaction);
            }
        }
        verify(repository, times(scheduledTransactions.size())).save(any());
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
