package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;

//Todo move to subpackage ( e.g. "flow")
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
