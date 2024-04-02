package com.greenfox.exam.badiusosicgreentribes.service;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.*;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.ProductionRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.TransactionRepository;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.UpgradeRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.TransactionHandlerFactory;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.UpgradeHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.BeanRegistry;
import org.springframework.stereotype.Service;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;

import java.util.List;

@Service
public class TransactionService {

    TransactionHandlerFactory handlerFactory;
    TransactionRepository repository;
    BeanRegistry<TransactionType, TransactionHandler<?>> handlerRegistry;

    public TransactionService(TransactionHandlerFactory handlerFactory,
                              TransactionRepository repository,
                              BeanRegistry<TransactionType, TransactionHandler<?>> handlerRegistry) {
        this.handlerFactory = handlerFactory;
        this.repository = repository;
        this.handlerRegistry = handlerRegistry;

        //FIXME ez a feltöltés a Spring Configuration része kell legyen.
        for (TransactionType type : TransactionType.values()) {
            handlerRegistry.add(type, (Class<? extends TransactionHandler<?>>) handlerFactory.getHandler(type).getClass());
            //Todo casting does not seem quite right here
        }
    }

    public void checkTransactions(){
        //Todo implement method
    }

    private List<Transaction> filterExpiredTransactions(List<Transaction> transactionList){
        //Todo implement correct filtering based on the current system date and started/duration
        return transactionList;
    }
}
