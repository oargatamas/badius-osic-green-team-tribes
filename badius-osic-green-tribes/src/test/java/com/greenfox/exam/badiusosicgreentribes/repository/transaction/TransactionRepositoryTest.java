package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;
    private Transaction transaction;

    @BeforeEach
    public void setupTestData(){

        transaction = Transaction.builder()
                .name("Food Production")
                .duration(120)
                .startAt(LocalDateTime.now())
                .recurring(true)
                .state(TransactionState.SCHEDULED)
                .build();
    }

    @Test
    @DisplayName("JUnit test for save Transaction operation")
    public void testSaveTransaction() {

        Transaction savedTransaction = transactionRepository.save(transaction);

        assertThat(savedTransaction.getId()).isNotNull();
    }

    @Test
    @DisplayName("JUnit test for update Transaction operation")
    public void testUpdateTransaction() {

        Transaction savedTransaction = transactionRepository.save(transaction);
        savedTransaction.setName("Gold Production");
        Transaction updatedTransaction = transactionRepository.save(savedTransaction);

        Transaction retrievedProduction = transactionRepository.findById(savedTransaction.getId()).orElse(null);
        assertNotNull(retrievedProduction);
        assertEquals(updatedTransaction, retrievedProduction);
    }

    @Test
    @DisplayName("JUnit test for finding Transaction by ID operation")
    public void testFindById() {

        Transaction savedTransaction = transactionRepository.save(transaction);

        Transaction retrievedTransaction = transactionRepository.findById(savedTransaction.getId()).orElse(null);

        assertNotNull(retrievedTransaction);
        assertEquals(savedTransaction, retrievedTransaction);
    }

    @Test
    @DisplayName("JUnit test for failing to find a Transaction by ID operation")
    public void testFindByIdToFail() {

        transactionRepository.save(transaction);
        long nonExistingId = -1;

        Optional<Transaction> retrievedTransactionOptional = transactionRepository.findById(nonExistingId);

        assertFalse(retrievedTransactionOptional.isPresent());
    }

    @Test
    @DisplayName("JUnit test for deleting Transaction operation")
    public void testDeleteTransaction() {

        Transaction savedTransaction = transactionRepository.save(transaction);

        transactionRepository.delete(savedTransaction);

        Optional<Transaction> deletedMovement = transactionRepository.findById(savedTransaction.getId());

        assertFalse(deletedMovement.isPresent());
    }
}
