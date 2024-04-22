package com.greenfox.exam.badiusosicgreentribes.service.battle.calculator;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitStats;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DamageCalculatorTest {

    DamageCalculator calculator = new DamageCalculator();

    @ParameterizedTest
    @ArgumentsSource(DamageCalcTestData.class)
    public void testCalcDamage(
            Integer attackerQuantity,
            Integer attackPerUnit,
            Integer defenderQuantity,
            Integer defensePerUnit,
            Integer defenderTroopHealth,
            Integer defenderUnitHealth,
            Integer expectedDamage,
            Integer expectedNoDeadUnits,
            Integer expectedNoDeadTroops,
            Float expectedChanceToRepost
    ) {

        Troop attackerTroop = Troop.builder()
                .quantity(attackerQuantity)
                .unit(Unit.builder()
                        .stats(UnitStats.builder()
                                .attack(attackPerUnit)
                                .build())
                        .build())
                .build();

        Troop defenderTroop = Troop.builder()
                .quantity(defenderQuantity)
                .stats(UnitStats.builder()
                        .health(defenderTroopHealth)
                        .build())
                .unit(Unit.builder()
                        .stats(UnitStats.builder()
                                .defense(defensePerUnit)
                                .health(defenderUnitHealth)
                                .build())
                        .build())
                .build();

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(expectedDamage, result.getDamage());
        assertEquals(expectedNoDeadUnits, result.getNoDeadUnits());
        assertEquals(expectedNoDeadTroops, result.getNoDeadTroops());
        assertEquals(expectedChanceToRepost, result.getChanceToRepost());
    }

    public static class DamageCalcTestData implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    // Basic attack scenario: attack just overcomes the defense
                    Arguments.of(
                            10, // attackerQuantity
                            15, // attackPerUnit
                            5,  // defenderQuantity
                            10, // defensePerUnit
                            500, // defenderTroopHealth
                            50,  // defenderUnitHealth
                            50,  // expectedDamage
                            1,   // expectedNoDeadUnits
                            0,   // expectedNoDeadTroops
                            1f   // expectedChanceToRepost
                    ),
                    // No defenders present
                    Arguments.of(
                            5,  // attackerQuantity
                            20, // attackPerUnit
                            0,  // defenderQuantity
                            0,  // defensePerUnit
                            0,   // defenderTroopHealth
                            0,   // defenderUnitHealth
                            0,   // expectedDamage
                            0,   // expectedNoDeadUnits
                            0,   // expectedNoDeadTroops
                            1f   // expectedChanceToRepost
                    ),
                    // Attack equals defense, resulting in no effective damage
                    Arguments.of(
                            5,  // attackerQuantity
                            10, // attackPerUnit
                            5,  // defenderQuantity
                            10, // defensePerUnit
                            100, // defenderTroopHealth
                            20,  // defenderUnitHealth
                            0,   // expectedDamage
                            0,   // expectedNoDeadUnits
                            0,   // expectedNoDeadTroops
                            1f   // expectedChanceToRepost
                    ),
                    // Attack significantly exceeds defense, multiple units are killed
                    Arguments.of(
                            5,  // attackerQuantity
                            100, // attackPerUnit
                            5,  // defenderQuantity
                            20, // defensePerUnit
                            500, // defenderTroopHealth
                            50,  // defenderUnitHealth
                            400, // expectedDamage
                            4,   // expectedNoDeadUnits
                            0,   // expectedNoDeadTroops
                            1f   // expectedChanceToRepost
                    ),
                    // Defenders survive due to high troop health, despite the attack
                    Arguments.of(
                            5,  // attackerQuantity
                            50, // attackPerUnit
                            5,  // defenderQuantity
                            25, // defensePerUnit
                            1000, // defenderTroopHealth
                            200,  // defenderUnitHealth
                            125,  // expectedDamage
                            0,    // expectedNoDeadUnits
                            0,    // expectedNoDeadTroops
                            1f    // expectedChanceToRepost
                    ),
                    // Exact damage needed to kill the troop
                    Arguments.of(
                            5,  // attackerQuantity
                            70, // attackPerUnit
                            5,  // defenderQuantity
                            20, // defensePerUnit
                            500, // defenderTroopHealth
                            100,  // defenderUnitHealth
                            250,  // expectedDamage
                            5,    // expectedNoDeadUnits
                            1,    // expectedNoDeadTroops
                            1f    // expectedChanceToRepost
                    ),
                    // Overkill scenario where the damage is more than enough to wipe out the troop
                    Arguments.of(
                            5,  // attackerQuantity
                            120, // attackPerUnit
                            5,  // defenderQuantity
                            10, // defensePerUnit
                            500, // defenderTroopHealth
                            50,  // defenderUnitHealth
                            550,  // expectedDamage
                            5,    // expectedNoDeadUnits
                            1,    // expectedNoDeadTroops
                            1f    // expectedChanceToRepost
                    ),
                    // Minimal attack versus high defense
                    Arguments.of(
                            1, // attackerQuantity
                            1, // attackPerUnit
                            1, // defenderQuantity
                            100, // defensePerUnit
                            1000, // defenderTroopHealth
                            1000, // defenderUnitHealth
                            0, // expectedDamage
                            0, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Large number of attackers, minimal defenders
                    Arguments.of(
                            1000, // attackerQuantity
                            10, // attackPerUnit
                            1, // defenderQuantity
                            5, // defensePerUnit
                            50, // defenderTroopHealth
                            50, // defenderUnitHealth
                            9950, // expectedDamage
                            1, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Troop health not perfectly divisible by unit health
                    Arguments.of(
                            10, // attackerQuantity
                            30, // attackPerUnit
                            10, // defenderQuantity
                            20, // defensePerUnit
                            295, // defenderTroopHealth
                            30, // defenderUnitHealth
                            100, // expectedDamage
                            3, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Zero attack and zero defense
                    Arguments.of(
                            10, // attackerQuantity
                            0, // attackPerUnit
                            10, // defenderQuantity
                            0, // defensePerUnit
                            500, // defenderTroopHealth
                            50, // defenderUnitHealth
                            0, // expectedDamage
                            0, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Negative values for attack
                    Arguments.of(
                            10, // attackerQuantity
                            -10, // attackPerUnit
                            10, // defenderQuantity
                            5, // defensePerUnit
                            500, // defenderTroopHealth
                            50, // defenderUnitHealth
                            0, // expectedDamage
                            0, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Boundary values check
                    Arguments.of(
                            10, // attackerQuantity
                            20, // attackPerUnit
                            10, // defenderQuantity
                            20, // defensePerUnit
                            100, // defenderTroopHealth
                            10, // defenderUnitHealth
                            0, // expectedDamage
                            0, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    ),
                    // Near integer overflow
                    Arguments.of(
                            Integer.MAX_VALUE, // attackerQuantity
                            1, // attackPerUnit
                            1, // defenderQuantity
                            1, // defensePerUnit
                            100, // defenderTroopHealth
                            100, // defenderUnitHealth
                            Integer.MAX_VALUE - 1, // expectedDamage
                            0, // expectedNoDeadUnits
                            0, // expectedNoDeadTroops
                            1f // expectedChanceToRepost
                    )
            );
        }

    }

}
