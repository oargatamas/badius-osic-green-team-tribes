package com.greenfox.exam.badiusosicgreentribes.transaction.registry;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionType;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.MovementHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.ProductionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.handler.TransactionHandler;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception.BeanRegistryKeyAlreadyExistException;
import com.greenfox.exam.badiusosicgreentribes.transaction.registry.exception.BeanRegistryKeyNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TransactionHandlerRegistryTest {

    private TransactionHandlerRegistry handlerRegistry;

    @BeforeEach
    void setUp() {
        handlerRegistry = new TransactionHandlerRegistry();
    }

    @Test
    void add() {
        //Test & Assert
        assertDoesNotThrow(() -> handlerRegistry.add(TransactionType.MOVEMENT, MovementHandler.class));
    }

    @Test
    void get() {
        //Setup
        handlerRegistry.add(TransactionType.MOVEMENT, MovementHandler.class);

        //Test
        Class<? extends TransactionHandler> result = handlerRegistry.get(TransactionType.MOVEMENT);

        //Assert
        assertEquals(MovementHandler.class, result);
    }

    @Test
    void keyAlreadyExistException() {
        handlerRegistry.add(TransactionType.PRODUCTION, ProductionHandler.class);
        assertThrows(BeanRegistryKeyAlreadyExistException.class, () -> handlerRegistry.add(TransactionType.PRODUCTION, ProductionHandler.class));
    }

    @Test
    void keyNotFoundException() {
        assertThrows(BeanRegistryKeyNotFoundException.class, () -> handlerRegistry.get(TransactionType.MOVEMENT));
    }
}