package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;

public class QueuedTurnSelector implements TurnSelector {
    @Override
    public Troop getAttacker(Army army) {
        return new Troop();
    }

    @Override
    public Troop getDefender(Army army) {
        return new Troop();
    }

}
