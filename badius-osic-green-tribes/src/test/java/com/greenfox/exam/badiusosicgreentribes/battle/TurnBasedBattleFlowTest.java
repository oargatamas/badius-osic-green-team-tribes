package com.greenfox.exam.badiusosicgreentribes.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitStats;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
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
    @BeforeEach
    public void initMocks(){
        UnitStats stats = UnitStats.builder().speed(10).attack(3).defense(3).health(100).build();
        List<Troop> list = new ArrayList<>(Arrays.asList(
                Troop.builder().quantity(10).stats(stats).build()));
        Army attackerArmy = Army.builder().name("attacker army").troops(list).build();
        Army defenderArmy = Army.builder().name("defender army").troops(list).build();

        when(damageCalculator.calcDamage(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(Damage.builder().damage(5)
                        .chanceToRepost(1F)
                        .NoDeadTroops(0)
                        .NoDeadUnits(0)
                        .build());
    }

    @Test
    void prepare() {
    }

    @Test
    void battle() {
    }
}