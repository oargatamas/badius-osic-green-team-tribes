package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.*;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.KingdomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TurnBasedBattleFlow implements BattleFlow {
    private TransactionService transactionService;
    private BeanFactory beanFactory;
    private KingdomService kingdomService;

    private TurnSelector selector;
    private DamageCalculator damageCalculator;


    @Override
    public BattleProperties prepare(Army attacker, Army defender) {
        return new BattleProperties(attacker, defender);
    }

    @Override
    public BattleLog battle(BattleProperties props) {

        Army attackerArmy = props.getAttackerArmy();
        Army defenderArmy = props.getDefenderArmy();
        TurnParticipants turnParticipants;
        Troop attacker;
        Troop defender;

        List<BattleTurn> turns = new ArrayList<>();

        while (!isArmyDepleted(attackerArmy) && !isArmyDepleted(defenderArmy)) {


            turnParticipants = selector.getAttackerDefender(attackerArmy, defenderArmy);
            attacker = turnParticipants.getAttacker();
            defender = turnParticipants.getDefender();

            Damage firstHit = damageCalculator.calcDamage(attacker, defender);
            Damage repost = Damage.builder().damage(0).build();
            applyDamage(firstHit, defender);
            if (firstHit.getChanceToRepost() > 50F && defender.getQuantity() > 0) {
                repost = damageCalculator.calcDamage(defender, attacker);
                applyDamage(repost, attacker);
            }

            turns.add(BattleTurn.builder()
                    .attacker(TroopInfo.builder()
                            .unit(attacker.getUnit().toString())
                            .quantity(attacker.getQuantity())
                            .health(attacker.getStats().getHealth())
                            .build())
                    .defender(TroopInfo.builder()
                            .unit(defender.getUnit().toString())
                            .quantity(defender.getQuantity())
                            .health(defender.getStats().getHealth())
                            .build())
                    .result(attacker.getUnit().getName() + " hit " + defender.getUnit().getName() + " for " + firstHit.getDamage() + " damage. " + attacker.getUnit().getName() + " was hit for " + repost.getDamage()) // Todo implement a pretty print data. e.g.: "Unicors hit with 23 313. 34 vampires perished"
                    .build());
        }

        return BattleLog.builder()
                .properties(BattleProperties.builder().attackerArmy(attackerArmy).defenderArmy(defenderArmy).build())
                .turns(turns)
                .attackerResult(BattleResult.builder()
                        .didItWin(isArmyDepleted(defenderArmy))
                        .build())
                .defenderResult(BattleResult.builder()
                        .didItWin(isArmyDepleted(attackerArmy))
                        .build())
                .build();
    }

    @Override
    public void finalize(BattleLog log) {

    }

    private void applyDamage(Damage damage, Troop troop) {
        troop.getStats().setHealth(troop.getStats().getHealth() - damage.getDamage());
        troop.setQuantity(troop.getQuantity() - damage.getNoDeadUnits());
    }

    private boolean isArmyDepleted(Army army) {
        return army.getTroops().stream().noneMatch(t -> t.getQuantity() > 0);
    }
}
