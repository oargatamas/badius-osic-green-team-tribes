package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;

public interface TransactionHandler<Trx extends Transaction> {
    void confirm(Trx transaction);
    void refund(Trx transaction);
}
