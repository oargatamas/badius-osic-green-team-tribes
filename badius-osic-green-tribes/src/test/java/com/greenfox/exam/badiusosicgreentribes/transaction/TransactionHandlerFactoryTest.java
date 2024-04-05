package com.greenfox.exam.badiusosicgreentribes.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.MovementRepository;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.TransactionHandlerRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionHandlerFactoryTest {

    @Mock
    BeanFactory beanFactory;

    @Mock
    TransactionHandlerRegistry handlerRegistry;

    @Mock
    MovementHandler movementHandler;

    @InjectMocks
    TransactionHandlerFactory transactionHandlerFactory;

    @BeforeEach
    void setupMocks(){
        when(beanFactory.getBean(MovementHandler.class)).thenReturn(movementHandler);
        doReturn(MovementHandler.class).when(handlerRegistry).get(TransactionType.MOVEMENT);
    }

    @Test
    void getHandler() {
        //Test
        TransactionHandler<? extends Transaction> handler = transactionHandlerFactory.getHandler(TransactionType.MOVEMENT);

        //Assert
        assertEquals(handler.getClass(), MovementHandler.class);
    }
}
