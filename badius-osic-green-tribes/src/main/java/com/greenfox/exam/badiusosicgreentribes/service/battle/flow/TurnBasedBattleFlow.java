package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import com.greenfox.exam.badiusosicgreentribes.service.KingdomService;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;

@AllArgsConstructor
public class TurnBasedBattleFlow implements BattleFlow {

    private TransactionService transactionService;
    private BeanFactory beanFactory;
    private KingdomService kingdomService;


    @Override
    public BattleProperties prepare(Army attacker, Army defender) {
        return null;
    }

    @Override
    public BattleLog battle(BattleProperties props) {
        return null;
    }

    @Override
    public void finalize(BattleLog log) {

    }
    private void applyDamage(Damage damage, Troop attacker, Troop defender){

    }
}
