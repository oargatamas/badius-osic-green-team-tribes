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
        HashMap<TransactionType, Class> testMap = new HashMap<>();
        testMap.put(TransactionType.MOVEMENT, MovementHandler.class);
        handlerRegistry.add(TransactionType.MOVEMENT, MovementHandler.class);
        assertEquals(testMap.get(TransactionType.MOVEMENT), handlerRegistry.get(TransactionType.MOVEMENT));
    }

    @Test
    void get() {
        handlerRegistry.add(TransactionType.MOVEMENT, MovementHandler.class);
        assertEquals(MovementHandler.class, handlerRegistry.get(TransactionType.MOVEMENT));
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