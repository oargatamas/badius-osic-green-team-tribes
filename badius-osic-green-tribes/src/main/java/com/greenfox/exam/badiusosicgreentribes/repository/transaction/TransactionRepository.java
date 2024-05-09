package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionsByStateIs(TransactionState state);

    List<Transaction> findTransactionsByIdInAndState(List<Long> ids, TransactionState state);

    Optional<Transaction> findTransactionByIdAndState(Long trxId, TransactionState transactionState);
}
