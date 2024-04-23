package com.greenfox.exam.badiusosicgreentribes.battle;

import com.greenfox.exam.badiusosicgreentribes.data.battle.BattleScenarios;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import com.greenfox.exam.badiusosicgreentribes.model.battle.TurnParticipants;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import com.greenfox.exam.badiusosicgreentribes.service.battle.flow.TurnBasedBattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.KingdomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.BeanFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
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

    @Test
    void prepare() {

    }

    @ParameterizedTest
    @ArgumentsSource(BattleLogProvider.class)
    void testBattle(BattleLog expectedBattleLog, boolean enableRepost) {
        // Mocks & Test Data preparation
        when(damageCalculator.calcDamage(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(Damage.builder().damage(10)
                        .chanceToRepost(enableRepost ? 1f : 0f)
                        .NoDeadTroops(0)
                        .NoDeadUnits(2)
                        .build());

        when(selector.getAttackerDefender(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(TurnParticipants.builder()
                        .attacker(expectedBattleLog.getProperties().getAttackerArmy().getTroops().getFirst())
                        .defender(expectedBattleLog.getProperties().getDefenderArmy().getTroops().getFirst())
                        .build());

        // Test
        BattleLog result = turnBasedBattleFlow.battle(expectedBattleLog.getProperties());


        // Asserts
        assertEquals(expectedBattleLog.getProperties().getAttackerArmy().getId(),result.getProperties().getAttackerArmy().getId());
        assertEquals(expectedBattleLog.getProperties().getAttackerArmy().getName(),result.getProperties().getAttackerArmy().getName());

        assertEquals(expectedBattleLog.getProperties().getAttackerArmy().getId(),result.getProperties().getDefenderArmy().getId());
        assertEquals(expectedBattleLog.getProperties().getAttackerArmy().getName(),result.getProperties().getDefenderArmy().getName());

        assertEquals(expectedBattleLog.getAttackerResult().getDidItWin(),result.getAttackerResult().getDidItWin());
        assertNotNull(result.getAttackerResult().getTransactions());
        assertEquals(expectedBattleLog.getAttackerResult().getTransactions().size(), result.getAttackerResult().getTransactions().size());

        assertEquals(expectedBattleLog.getDefenderResult().getDidItWin(),result.getDefenderResult().getDidItWin());
        assertNotNull(result.getDefenderResult().getTransactions());
        assertEquals(expectedBattleLog.getDefenderResult().getTransactions().size(), result.getDefenderResult().getTransactions().size());

        assertNotNull(result.getTurns());
        assertEquals(expectedBattleLog.getTurns().size(), result.getTurns().size());

        for (int i = 0; i < result.getTurns().size(); i++) {
            assertEquals(expectedBattleLog.getTurns().get(i).getResult(), result.getTurns().get(i).getResult());

            assertEquals(expectedBattleLog.getTurns().get(i).getAttacker().getUnit(), result.getTurns().get(i).getAttacker().getUnit());
            assertEquals(expectedBattleLog.getTurns().get(i).getAttacker().getQuantity(), result.getTurns().get(i).getAttacker().getQuantity());
            assertEquals(expectedBattleLog.getTurns().get(i).getAttacker().getHealth(), result.getTurns().get(i).getAttacker().getHealth());

            assertEquals(expectedBattleLog.getTurns().get(i).getDefender().getUnit(), result.getTurns().get(i).getDefender().getUnit());
            assertEquals(expectedBattleLog.getTurns().get(i).getDefender().getQuantity(), result.getTurns().get(i).getDefender().getQuantity());
            assertEquals(expectedBattleLog.getTurns().get(i).getDefender().getHealth(), result.getTurns().get(i).getDefender().getHealth());
        }
    }


    public static class BattleLogProvider implements ArgumentsProvider{

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(BattleScenarios.successfulDefenseWithoutRepost(), false),
                    Arguments.of(BattleScenarios.successfulDefenseWithoutRepost(), false),
                    Arguments.of(BattleScenarios.successfulDefenseWithRepost(), true),
                    Arguments.of(BattleScenarios.successfulDefenseWithRepost(), true)
            );
        }
    }
}