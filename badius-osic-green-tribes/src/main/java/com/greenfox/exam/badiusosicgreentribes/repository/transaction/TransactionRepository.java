package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findTransactionsByStateIs(TransactionState state);
}
