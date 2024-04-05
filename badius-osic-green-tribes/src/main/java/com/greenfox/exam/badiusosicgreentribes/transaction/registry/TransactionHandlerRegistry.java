package com.greenfox.exam.badiusosicgreentribes.transaction.registry;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import org.springframework.stereotype.Component;


public class TransactionHandlerRegistry extends BeanRegistry<TransactionType, TransactionHandler>{
}
