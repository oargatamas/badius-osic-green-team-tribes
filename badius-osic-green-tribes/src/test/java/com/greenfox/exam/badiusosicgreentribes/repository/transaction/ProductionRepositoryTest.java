package com.greenfox.exam.badiusosicgreentribes.repository.transaction;


import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;

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
                .type(ProductionUnitType.FOOD)
                .targetKingdom(targetKingdom)
                .build();
    }

    @Test
    @DisplayName("JUnit test for save Production operation")
    public void testSaveProduction() {

        Production savedProduction = productionRepository.save(production);

        assertThat(savedProduction).isNotNull();
    }

    @Test
    @DisplayName("JUnit test for update Production operation")
    public void testUpdateProduction() {

        Production savedProduction = productionRepository.save(production);
        Kingdom newTargetKingdom = new Kingdom();
        savedProduction.setTargetKingdom(newTargetKingdom);
        Production updatedProduction = productionRepository.save(savedProduction);

        Production retrievedProduction = productionRepository.findById(savedProduction.getId()).orElse(null);
        assertEquals(updatedProduction, retrievedProduction);
        assertEquals(newTargetKingdom, retrievedProduction.getTargetKingdom());
    }

    @Test
    @DisplayName("JUnit test for finding Production by ID operation")
    public void testFindById() {

        Production savedProduction = productionRepository.save(production);

        Optional<Production> retrievedProductionOptional = productionRepository.findById(savedProduction.getId());

        assertEquals(savedProduction, retrievedProductionOptional.orElse(null));
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