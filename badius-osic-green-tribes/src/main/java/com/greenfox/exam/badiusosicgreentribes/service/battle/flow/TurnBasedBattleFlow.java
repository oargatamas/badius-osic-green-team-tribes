package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;


public class TurnBasedBattleFlow implements BattleFlow {
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
}
