package com.greenfox.exam.badiusosicgreentribes.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitStats;
import com.greenfox.exam.badiusosicgreentribes.model.battle.*;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import com.greenfox.exam.badiusosicgreentribes.service.battle.flow.TurnBasedBattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.KingdomService;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class TurnBasedBattleFlowTest {
    @Mock
    private TransactionService transactionService;
    @Mock
    private BeanFactory beanFactory;
    @Mock
    private KingdomService kingdomService;
    @Mock
    private TurnSelector selector;
    @Mock
    private DamageCalculator damageCalculator;
    @InjectMocks
    private TurnBasedBattleFlow turnBasedBattleFlow;
    UnitStats stats;
    List<Troop> list;
    Army attackerArmy;
    Army defenderArmy;
    BattleProperties props;
    List<BattleTurn> turns;
    @BeforeEach
    public void initMocks(){
        stats = UnitStats.builder().speed(10).attack(13).defense(3).health(20).aggressivity(1F).build();
        list = new ArrayList<>(Arrays.asList(
                Troop.builder().quantity(4).unit(Unit.builder().name("test").build()).stats(stats).build()));
        attackerArmy = Army.builder().name("attacker army").troops(list).build();
        defenderArmy = Army.builder().name("defender army").troops(list).build();

        props = BattleProperties.builder().attackerArmy(attackerArmy).defenderArmy(defenderArmy).build();
        turns = new ArrayList<>(Arrays.asList(
                BattleTurn.builder()
                        .attacker(TroopInfo.builder().unit("test").quantity(4).health(20).build())
                        .defender(TroopInfo.builder().unit("test").quantity(2).health(10).build())
                        .result("test hit test for 10 damage. test was hit for 0").build(),
                BattleTurn.builder()
                        .attacker(TroopInfo.builder().unit("test").quantity(4).health(20).build())
                        .defender(TroopInfo.builder().unit("test").quantity(0).health(0).build())
                        .result("test hit test for 10 damage. test was hit for 0").build()
                ));

        when(damageCalculator.calcDamage(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(Damage.builder().damage(10)
                        .chanceToRepost(1F)
                        .NoDeadTroops(0)
                        .NoDeadUnits(2)
                        .build());
        when(selector.getAttackerDefender(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(TurnParticipants.builder()
                        .attacker(attackerArmy.getTroops().getFirst())
                        .defender(defenderArmy.getTroops().getFirst())
                        .build());
    }

    @Test
    void prepare() {

    }

    @Test
    void battle() {
        BattleLog log = BattleLog.builder().properties(props)
                .attackerResult(BattleResult.builder().didItWin(true).build())
                .defenderResult(BattleResult.builder().didItWin(false).build())
                .turns(turns)
                .build();
        BattleLog result = turnBasedBattleFlow.battle(props);
        //assertTrue(turnBasedBattleFlow.battle(props).getTurns().equals(turns));
        assertEquals(log.getAttackerResult().getDidItWin(), result.getAttackerResult().getDidItWin());
        assertEquals(log.getDefenderResult().getDidItWin(), result.getDefenderResult().getDidItWin());

    }
}