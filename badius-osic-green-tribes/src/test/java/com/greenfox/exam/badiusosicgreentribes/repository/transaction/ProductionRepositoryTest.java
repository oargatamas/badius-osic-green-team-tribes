package com.greenfox.exam.badiusosicgreentribes.repository.transaction;


import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.ProductionUnitType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductionRepositoryTest {

    @Autowired
    private ProductionRepository productionRepository;
    private Production production;


    @BeforeEach
    public void setupTestData() {

        Kingdom targetKingdom = new Kingdom();

        production = Production.builder()
                .quantity(1)
                .productionType(ProductionUnitType.FOOD)
                .targetKingdom(targetKingdom)
                .build();
    }

    @Test
    @DisplayName("JUnit test for save Production operation")
    public void testSaveProduction() {

        Production savedProduction = productionRepository.save(production);

        assertThat(savedProduction.getId()).isNotNull();
    }

    @Test
    @DisplayName("JUnit test for update Production operation")
    public void testUpdateProduction() {

        Production savedProduction = productionRepository.save(production);
        Kingdom newTargetKingdom = new Kingdom();
        savedProduction.setTargetKingdom(newTargetKingdom);
        Production updatedProduction = productionRepository.save(savedProduction);

        Production retrievedProduction = productionRepository.findById(savedProduction.getId()).orElse(null);
        assertNotNull(retrievedProduction);
        assertEquals(updatedProduction, retrievedProduction);
        assertEquals(newTargetKingdom, retrievedProduction.getTargetKingdom());
    }

    @Test
    @DisplayName("JUnit test for finding Production by ID operation")
    public void testFindById() {

        Production savedProduction = productionRepository.save(production);

        Production retrievedProduction = productionRepository.findById(savedProduction.getId()).orElse(null);

        assertNotNull(retrievedProduction);
        assertEquals(savedProduction, retrievedProduction);
    }

    @Test
    @DisplayName("JUnit test for failing to find a Production by ID operation")
    public void testFindByIdToFail() {

        productionRepository.save(production);
        long nonExistingId = -1;

        Optional<Production> retrievedProductionOptional = productionRepository.findById(nonExistingId);

        assertFalse(retrievedProductionOptional.isPresent());
    }

    @Test
    @DisplayName("JUnit test for deleting Production operation")
    public void testDeleteProduction() {

        Production savedProduction = productionRepository.save(production);

        productionRepository.delete(savedProduction);

        Optional<Production> deletedMovement = productionRepository.findById(savedProduction.getId());

        assertFalse(deletedMovement.isPresent());
    }

}