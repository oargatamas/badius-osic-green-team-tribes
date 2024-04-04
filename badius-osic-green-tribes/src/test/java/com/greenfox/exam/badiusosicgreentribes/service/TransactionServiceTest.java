package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    TransactionHandlerFactory handlerFactory;
    @Mock
    TransactionRepository repository;
    @Mock
    MovementRepository movementRepository;
    @Mock
    MovementHandler movementHandler;
    @InjectMocks
    TransactionService transactionService;

    List<Transaction> transactionList;
    @BeforeEach
    void setupMocks(){
        transactionList = new ArrayList<>();
        transactionList.add(new Transaction.Builder().state(TransactionState.SCHEDULED).startAt(LocalDateTime.now().plusDays(1)).duration(3600).build());
        transactionList.add(new Transaction.Builder().state(TransactionState.COMPLETED).build());
        transactionList.add(new Transaction.Builder().state(TransactionState.FAILED).build());
        transactionList.add(new Transaction.Builder().state(TransactionState.CANCELLED).build());
        transactionList.add(new Transaction.Builder().state(TransactionState.SCHEDULED).startAt(LocalDateTime.now().minusDays(1)).duration(3600).build());
        when(repository.findTransactionsByStateIs(TransactionState.SCHEDULED)).thenReturn(transactionList.stream().filter(t -> t.getState().equals(TransactionState.SCHEDULED)).toList());
    }
    @Test
    void checkTransactions() {
        when(handlerFactory.getHandler(transactionList.get(4))).thenReturn(new MovementHandler(movementRepository));
        transactionService.checkTransactions();
        assertEquals(transactionList.get(4).getState(), TransactionState.COMPLETED);
    }
}