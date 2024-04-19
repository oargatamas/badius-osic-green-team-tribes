package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    TransactionHandlerFactory handlerFactory;
    TransactionRepository repository;

    public TransactionService(TransactionHandlerFactory handlerFactory, TransactionRepository repository) {
        this.handlerFactory = handlerFactory;
        this.repository = repository;
    }

    public void checkTransactions() {
        List<Transaction> transactions = repository.findTransactionsByStateIs(TransactionState.SCHEDULED);
        List<Transaction> expiredTransactions = filterExpiredTransactions(transactions);
        expiredTransactions.forEach(transaction -> {
            TransactionHandler handler = handlerFactory.getHandler(transaction.getTransactionType());
            try {
                handler.confirm(transaction);
                transaction.setState(TransactionState.COMPLETED);
            } catch (Exception e) {
                transaction.setState(TransactionState.FAILED);
            }
            repository.save(transaction);
        });
    }

    private List<Transaction> filterExpiredTransactions(List<Transaction> transactionList) {
        LocalDateTime now = LocalDateTime.now();
        return transactionList.stream()
                .filter(transaction -> isTransactionExpired(transaction.getStartAt(), transaction.getDuration(), now))
                .collect(Collectors.toList());
    }

    private boolean isTransactionExpired(LocalDateTime startedAt, Integer durationInSeconds, LocalDateTime currentTime) {
        LocalDateTime expirationTime = startedAt.plusSeconds(durationInSeconds);
        return expirationTime.isBefore(currentTime);
    }

    public void cancelTransactions(List<Long> trxIds) {
        //The desired functionality is to change the state of the input ids to CANCELLED if possible (State not in FAILED or COMPLETED).
        //All the cancelled transactions need to be refunded on the kingdom. This refund logic may vary
        //based on the transaction type, therefore the related TransactionHandler.refund(trx : Trx) : void need to be called.

        List<Transaction> transactions = trxIds.stream()
                        .map(trxId -> repository.findTransactionsById(trxId))
                        .flatMap(List::stream)
                        .toList();

        List<Transaction> scheduledTransactions = transactions.stream()
                .filter(this::isTransactionScheduled)
                .toList();

        scheduledTransactions.forEach(transaction -> {
            try {
                transaction.setState(TransactionState.CANCELLED);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            repository.save(transaction);
            TransactionHandler handler = handlerFactory.getHandler(transaction.getTransactionType());
            try {
                handler.refund(transaction);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    private boolean isTransactionScheduled(Transaction transaction) {
        TransactionState state = TransactionState.SCHEDULED;
        return transaction.getState().equals(state);
    }
}
