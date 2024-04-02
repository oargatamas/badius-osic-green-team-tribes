package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    TransactionHandlerFactory handlerFactory;
    TransactionRepository repository;

    public TransactionService(TransactionHandlerFactory handlerFactory, TransactionRepository repository) {
        this.handlerFactory = handlerFactory;
        this.repository = repository;
    }

    public void checkTransactions(){
        List<Transaction> transactions = repository.findTransactionsByStateIs(TransactionState.SCHEDULED);
        List<Transaction> expiredTransactions = filterExpiredTransactions(transactions);
        expiredTransactions.forEach(transaction -> {
            TransactionHandler<Transaction> handler = handlerFactory.getHandler(transaction);
            if (handler != null) {
                handler.confirm(transaction);
                transaction.setState(TransactionState.COMPLETED);
                repository.save(transaction);
            } else {
                transaction.setState(TransactionState.FAILED);
                repository.save(transaction);
            }
        });
    }

    private List<Transaction> filterExpiredTransactions(List<Transaction> transactionList){
        LocalDateTime now = LocalDateTime.now();
        return transactionList.stream()
                .filter(transaction -> isTransactionExpired(transaction.getStartAt(), transaction.getDuration(), now))
                .collect(Collectors.toList());
    }

    private boolean isTransactionExpired(LocalDateTime startedAt, Integer durationInSeconds, LocalDateTime currentTime) {
        LocalDateTime expirationTime = startedAt.plusSeconds(durationInSeconds);
        return expirationTime.isBefore(currentTime);
    }
}
