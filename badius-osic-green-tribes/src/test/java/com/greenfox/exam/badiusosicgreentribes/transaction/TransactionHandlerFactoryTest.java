package com.greenfox.exam.badiusosicgreentribes.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.BeanFactory;

import static org.junit.jupiter.api.Assertions.*;

class TransactionHandlerFactoryTest {

    BeanFactory beanFactory;
    TransactionHandlerFactory transactionHandlerFactory;
    TransactionHandlerRegistry handlerRegistry;

    @Mock
    MovementRepository movementRepository;

    @BeforeEach
    void setUp() {
        handlerRegistry = new TransactionHandlerRegistry();
        transactionHandlerFactory = new TransactionHandlerFactory(beanFactory, handlerRegistry);
    }

    @Test
    void getHandler() {
        assertEquals(new MovementHandler(), transactionHandlerFactory.getHandler(TransactionType.MOVEMENT));
    }
}
