package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.*;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;
import java.util.List;


public class TurnBasedBattleFlow implements BattleFlow {
    private TransactionService transactionService;
    private BeanFactory beanFactory;
   // private KingdomService kingdomService;

    private Troop attacker;
    private Troop defender;
    public TurnBasedBattleFlow(TransactionService transactionService, BeanFactory beanFactory /* , KingdomService kingdomService*/) {
        this.transactionService = transactionService;
        this.beanFactory = beanFactory;
      //  this.kingdomService = kingdomService;
    }

    @Override
    public BattleProperties prepare(Army attacker, Army defender) {
        return new BattleProperties(attacker, defender);
    }

    @Override
    public BattleLog battle(BattleProperties props) {
        DamageCalculator damageCalculator = new DamageCalculator();
        QueuedTurnSelector queuedTurnSelector = new QueuedTurnSelector();
        Army attackerArmy = props.getAttackerArmy();
        Army defenderArmy = props.getDefenderArmy();
        Troop troop1;
        Troop troop2;
        Damage damage;
        List<BattleTurn> turns = new ArrayList<>();
        while (attackerArmy.getTroops().stream().anyMatch(t -> t.getQuantity() > 0) && defenderArmy.getTroops().stream().anyMatch(t -> t.getQuantity() > 0)){
            troop1 = queuedTurnSelector.getAttacker(attackerArmy);
            troop2 = queuedTurnSelector.getDefender(defenderArmy);
            chooseAttackerDefender(troop1, troop2);
            damage = damageCalculator.calcDamage(attacker, defender);
            applyDamage(damage, attacker, defender);

            if(attacker.getId() == troop1.getId()){
                troop1 = attacker;
                troop2 = defender;
            }else if(defender.getId() == troop1.getId()){
                troop1 = defender;
                troop2 = attacker;
            }else throw new RuntimeException("Something went wrong");
            turns.add(new BattleTurn(new TroopInfo(attacker.getUnit().toString(), attacker.getQuantity(), attacker.getStats().getHealth()), new TroopInfo(defender.getUnit().toString(), defender.getQuantity(), defender.getStats().getHealth()), damage.getDamage().toString()));
        }
        BattleResult attackerResult;
        BattleResult defenderResult;
        if(attackerArmy.getTroops().stream().allMatch(t -> t.getQuantity() < 1)){
            attackerResult = BattleResult.builder().didItWin(false).build(); //todo implement method
            defenderResult = BattleResult.builder().didItWin(true).build();
        }else {
            attackerResult = BattleResult.builder().didItWin(true).build();
            defenderResult = BattleResult.builder().didItWin(false).build();
        }
        return new BattleLog(props, turns, attackerResult, defenderResult);
    }

    @Override
    public void finalize(BattleLog log) {

    }
    private void applyDamage(Damage damage, Troop attacker, Troop defender){

    }
    private void chooseAttackerDefender(Troop troop1, Troop troop2){
        int sp1 = (int)(Math.random() * 100 + 1 + troop1.getStats().getSpeed());
        int sp2 = (int)(Math.random() * 100 + 1 + troop2.getStats().getSpeed());
        if(sp1 == sp2){
            chooseAttackerDefender(troop1, troop2);
        } else if (sp1 > sp2) {
            attacker = troop1;
            defender = troop2;
        }else {
            attacker = troop2;
            defender = troop1;
        }


    }
}
