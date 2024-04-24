package com.greenfox.exam.badiusosicgreentribes.transaction.handler.exception;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;

public class TransactionRefundNotAllowedException extends RuntimeException {

    public TransactionRefundNotAllowedException(Movement transaction) {
        super(getMessage(transaction));
    }

    public TransactionRefundNotAllowedException(Movement transaction, Throwable cause) {
        super(getMessage(transaction), cause);
    }

    private static String getMessage(Movement transaction){
        return "Transaction %s cannot be refunded".formatted(transaction);
    }
}
