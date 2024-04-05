package com.greenfox.exam.badiusosicgreentribes.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionHandlerFactory {

    private BeanFactory beanFactory;
    private TransactionHandlerRegistry handlerRegistry;




    public TransactionHandler<Transaction> getHandler(Transaction transaction){
        //return beanFactory.getBean(handlerRegistry.get(transaction.getType()));
        return null; // Todo implement method
    }
}
