package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;

import java.util.List;

public class TransactionService {

    TransactionHandlerFactory handlerFactory;
    TransactionRepository<Transaction> repository;

    public void checkTransactions(){
        //Todo implement method
    }

    private List<Transaction> filterExpiredTransactions(List<Transaction> transactionList){
        //Todo implement correct filtering based on the current system date and started/duration
        return transactionList;
    }
}