package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository<Trx extends Transaction> extends JpaRepository<Integer, Trx> {

    List<Transaction> findScheduledTransactions(); // Todo implement query behind
}
