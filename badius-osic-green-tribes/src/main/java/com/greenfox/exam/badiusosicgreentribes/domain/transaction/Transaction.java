package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import java.sql.Timestamp;

public class Transaction {
    private String name;
    private Integer duration;
    private Timestamp startAt;
    private boolean recurring;
    private TransactionState state;
}
