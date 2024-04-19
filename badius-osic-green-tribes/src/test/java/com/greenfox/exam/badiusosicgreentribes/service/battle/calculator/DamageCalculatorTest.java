package com.greenfox.exam.badiusosicgreentribes.service.battle.calculator;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitStats;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DamageCalculatorTest {
    @Mock
    Troop attackerTroop, defenderTroop;
    @Mock
    Unit attackerUnit, defenderUnit;
    @Mock
    UnitStats attackerStats, defenderStats, defenderTroopStats;
    @InjectMocks
    DamageCalculator calculator;

    @BeforeEach
    public void setUp() {

        when(attackerTroop.getUnit()).thenReturn(attackerUnit);
        when(defenderTroop.getUnit()).thenReturn(defenderUnit);
        when(attackerUnit.getStats()).thenReturn(attackerStats);
        when(defenderUnit.getStats()).thenReturn(defenderStats);

        when(attackerStats.getAttack()).thenReturn(30);
        when(defenderStats.getDefense()).thenReturn(20);
        when(defenderUnit.getStats().getHealth()).thenReturn(100);

        when(defenderTroop.getStats()).thenReturn(defenderTroopStats);
        when(defenderTroopStats.getHealth()).thenReturn(500);

        when(attackerTroop.getQuantity()).thenReturn(10);
        lenient().when(defenderTroop.getQuantity()).thenReturn(5);
    }



    @Test
    public void testCalcDamage_StandardCase() {
        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(0, result.getDamage());
        assertEquals(1, result.getNoDeadUnits());
        assertEquals(0, result.getNoDeadTroops());
    }

    @Test
    public void testCalcDamage_AllDefendersDie() {

        when(attackerStats.getAttack()).thenReturn(100);

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(0, result.getDamage());
        assertEquals(5, result.getNoDeadUnits());
        assertEquals(1, result.getNoDeadTroops());
    }

    @Test
    public void testCalcDamage_PartialDamageNoDeaths() {

        when(attackerStats.getAttack()).thenReturn(25);

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(50, result.getDamage());
        assertEquals(0, result.getNoDeadUnits());
        assertEquals(0, result.getNoDeadTroops());
    }

    @Test
    public void testCalcDamage_LowDamageBlockedByDefense() {

        when(attackerStats.getAttack()).thenReturn(15);

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(0, result.getDamage());
        assertEquals(0, result.getNoDeadUnits());
        assertEquals(0, result.getNoDeadTroops());
    }

    @Test
    public void testCalcDamage_SameDamageAndDefenseValues() {

        when(attackerStats.getAttack()).thenReturn(20);

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(0, result.getDamage());
        assertEquals(0, result.getNoDeadUnits());
        assertEquals(0, result.getNoDeadTroops());
    }

    @Test
    public void testCalcDamage_ExactDamageNeededToKillTroop() {

        when(attackerStats.getAttack()).thenReturn(70);

        Damage result = calculator.calcDamage(attackerTroop, defenderTroop);

        assertEquals(0, result.getDamage());
        assertEquals(5, result.getNoDeadUnits());
        assertEquals(1, result.getNoDeadTroops());
    }
}
