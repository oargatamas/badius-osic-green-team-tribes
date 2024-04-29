package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
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

        List<Transaction> scheduledTransactions = repository.findTransactionsByIdInAndState(trxIds, TransactionState.SCHEDULED);

        scheduledTransactions.forEach(transaction -> {
            try {
                TransactionHandler handler = handlerFactory.getHandler(transaction.getTransactionType());
                handler.refund(transaction);

                transaction.setState(TransactionState.CANCELLED);
                repository.save(transaction);
            } catch (Exception e) {
                log.error(MessageFormat.format("Transaction cancellation failed on {0}", transaction.getId()), e);
            }
        });
    }

    public void cancelTransaction(Long trxId) {
        Transaction scheduledTransaction = repository.findTransactionByIdAndState(trxId, TransactionState.SCHEDULED);

        try {
            TransactionHandler handler = handlerFactory.getHandler(scheduledTransaction.getTransactionType());
            handler.refund(scheduledTransaction);

            scheduledTransaction.setState(TransactionState.CANCELLED);
            repository.save(scheduledTransaction);
        } catch (Exception e) {
            log.error(MessageFormat.format("Transaction cancellation failed on {0}", scheduledTransaction.getId()), e);
        }
    }
}
