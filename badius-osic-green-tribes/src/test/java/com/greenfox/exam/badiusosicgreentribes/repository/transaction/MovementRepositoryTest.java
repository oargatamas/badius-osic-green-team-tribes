package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MovementRepositoryTest {

    @Autowired
    private MovementRepository movementRepository;
    private Movement movement;


    @BeforeEach
    public void setupTestData() {

        Kingdom origin = new Kingdom();
        Kingdom destination = new Kingdom();

        movement = new Movement.Builder()
                .origin(origin)
                .destination(destination)
                .build();
    }

    @Test
    @DisplayName("JUnit test for save Movement operation")
    public void testSaveMovement() {

        Movement savedMovement = movementRepository.save(movement);

        assertThat(savedMovement.getId()).isNotNull();
    }

    @Test
    @DisplayName("JUnit test for update Movement operation")
    public void testUpdateMovement() {

        Movement savedMovement = movementRepository.save(movement);
        Kingdom newOrigin = new Kingdom();
        savedMovement.setOrigin(newOrigin);
        Movement updatedMovement = movementRepository.save(savedMovement);

        Movement retrievedMovement = movementRepository.findById(savedMovement.getId()).orElse(null);
        assertNotNull(retrievedMovement);
        assertEquals(updatedMovement, retrievedMovement);
        assertEquals(newOrigin, retrievedMovement.getOrigin());
    }

    @Test
    @DisplayName("JUnit test for finding Movement by ID operation")
    public void testFindById() {

        Movement savedMovement = movementRepository.save(movement);

        Optional<Movement> retrievedMovementOptional = movementRepository.findById(savedMovement.getId());

        assertNotNull(retrievedMovementOptional);
        assertEquals(savedMovement, retrievedMovementOptional.orElse(null));
    }

    @Test
    @DisplayName("JUnit test for failing to find a Movement by ID operation")
    public void testFindByIdToFail() {

        movementRepository.save(movement);
        long nonExistingId = -1;

        Optional<Movement> retrievedMovementOptional = movementRepository.findById(nonExistingId);

        assertFalse(retrievedMovementOptional.isPresent());
    }

    @Test
    @DisplayName("JUnit test for deleting Movement operation")
    public void testDeleteMovement() {

        Movement savedMovement = movementRepository.save(movement);

        movementRepository.delete(savedMovement);

        Optional<Movement> deletedMovement = movementRepository.findById(savedMovement.getId());

        assertFalse(deletedMovement.isPresent());
    }
}
