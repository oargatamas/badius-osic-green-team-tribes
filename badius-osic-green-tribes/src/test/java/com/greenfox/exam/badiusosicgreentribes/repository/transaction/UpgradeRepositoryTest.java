package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.ProductionUnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Upgrade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class UpgradeRepositoryTest {

    @Autowired
    private UpgradeRepository upgradeRepository;
    private Upgrade upgrade;


    @BeforeEach
    public void setupTestData(){

        upgrade = Upgrade.builder()
                .type(ProductionUnitType.FOOD)
                .targetLevel(5)
                .TargetId(1)
                .build();
    }

    @Test
    @DisplayName("JUnit test for save Upgrade operation")
    public void testSaveUpgrade() {

        Upgrade savedUpgrade = upgradeRepository.save(upgrade);

        assertThat(savedUpgrade).isNotNull();
    }

    @Test
    @DisplayName("JUnit test for update Upgrade operation")
    public void testUpdateUpgrade() {

        Upgrade savedUpgrade = upgradeRepository.save(upgrade);
        savedUpgrade.setTargetLevel(5);
        Upgrade updatedUpgrade = upgradeRepository.save(upgrade);

        Upgrade retrievedUpgrade = upgradeRepository.findById(savedUpgrade.getId()).orElse(null);
        assertEquals(updatedUpgrade, retrievedUpgrade);
    }

    @Test
    @DisplayName("JUnit test for finding Upgrade by ID operation")
    public void testFindById() {

        Upgrade savedUpgrade = upgradeRepository.save(upgrade);

        Optional<Upgrade> retrievedMovementOptional = upgradeRepository.findById(savedUpgrade.getId());

        assertEquals(savedUpgrade, retrievedMovementOptional.orElse(null));
    }

    @Test
    @DisplayName("JUnit test for deleting Upgrade operation")
    public void testDeleteUpgrade() {

        Upgrade savedUpgrade = upgradeRepository.save(upgrade);

        upgradeRepository.delete(savedUpgrade);

        Optional<Upgrade> deletedUpgrade = upgradeRepository.findById(savedUpgrade.getId());

        assertFalse(deletedUpgrade.isPresent());
    }
}