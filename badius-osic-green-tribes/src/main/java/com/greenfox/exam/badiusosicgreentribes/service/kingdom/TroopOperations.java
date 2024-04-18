package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;

public interface TroopOperations {

    Transaction trainUnits(Kingdom kingdom, UnitType unit, Integer quantity);
    Transaction promoteTroop(Kingdom kingdom, Troop troopToUpgrade);
}
