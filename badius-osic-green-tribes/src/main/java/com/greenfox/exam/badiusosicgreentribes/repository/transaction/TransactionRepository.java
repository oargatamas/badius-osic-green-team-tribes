package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Integer, Transaction> {

    List<Transaction> findScheduledTransactions(); // Todo implement query behind
}
