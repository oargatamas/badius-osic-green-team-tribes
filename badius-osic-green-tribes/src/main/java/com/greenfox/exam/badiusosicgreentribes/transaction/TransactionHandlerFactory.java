package com.greenfox.exam.badiusosicgreentribes.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import org.springframework.beans.factory.BeanFactory;

public class TransactionHandlerFactory {

    BeanFactory beanFactory;
    TransactionHandlerRegistry handlerRegistry;

    public TransactionHandler<Transaction> getHandler(Transaction transaction){
        //return beanFactory.getBean(handlerRegistry.get(transaction.getType()));
        return null; // Todo implement method
    }
}
