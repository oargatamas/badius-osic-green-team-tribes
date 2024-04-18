package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;

public interface TurnSelector {

    Troop getAttacker(Army army);
    Troop getDefender(Army army);
}
