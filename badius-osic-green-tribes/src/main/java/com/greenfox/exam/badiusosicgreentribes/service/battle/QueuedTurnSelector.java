package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;

public class QueuedTurnSelector implements TurnSelector {
    @Override
    public Troop getAttacker(Army army) {
        return null;
    }

    @Override
    public Troop getDefender(Army army) {
        return null;
    }
}
