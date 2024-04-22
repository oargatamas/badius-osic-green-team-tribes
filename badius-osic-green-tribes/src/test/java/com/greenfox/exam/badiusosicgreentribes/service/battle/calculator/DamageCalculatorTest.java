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

    DamageCalculator calculator;

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
                   Arguments.of(
                           1, //attackerQuantity
                           1, //attackPerUnit
                           1, //defenderQuantity
                           1, //defensePerUnit
                           1, //defenderTroopHealth
                           1, //defenderUnitHealth
                           0, //expectedDamage
                           0, //expectedNoDeadUnits
                           0, //expectedNoDeadTroops
                           0f //expectedChanceToRepost
                   )
            );
        }
    }

}
