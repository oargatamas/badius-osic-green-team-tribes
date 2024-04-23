package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Storage;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BattleServiceTest {

    @Mock
    private BattleFlow battleFlow;
    @InjectMocks
    private BattleService battleService;


    @Test
    void startBattle_ValidInput_ReturnsBattleLog() {
        Movement attacker = new Movement();
        attacker.setArmy(new Army());
        Army defenderArmy = new Army();
        attacker.setDestination(new Kingdom());
        attacker.getDestination().setStorage(new Storage());
        attacker.getDestination().getStorage().setDefenderArmy(defenderArmy);

        BattleProperties battleProperties = new BattleProperties();
        BattleLog expectedLog = new BattleLog();

        when(battleFlow.prepare(any(), any())).thenReturn(battleProperties);
        when(battleFlow.battle(battleProperties)).thenReturn(expectedLog);

        BattleLog result = battleService.startBattle(attacker);

        assertNotNull(result);
        assertEquals(expectedLog, result);

        verify(battleFlow, times(1)).finalize(expectedLog);

    }

    @Test
    void startBattle_AttackerIsNull_ThrowsIllegalArgumentException() {
        Movement attacker = null;

        assertThrows(IllegalArgumentException.class, () -> {
            battleService.startBattle(attacker);
        });

    }

    @Test
    void startBattle_DefenderArmyIsNull_ThrowsIllegalArgumentException() {
        Movement attacker = new Movement();
        attacker.setArmy(new Army());

        attacker.setDestination(new Kingdom());
        attacker.getDestination().setStorage(new Storage());

        assertThrows(IllegalArgumentException.class, () -> {
            battleService.startBattle(attacker);
        });

        verifyNoInteractions(battleFlow);
    }
}