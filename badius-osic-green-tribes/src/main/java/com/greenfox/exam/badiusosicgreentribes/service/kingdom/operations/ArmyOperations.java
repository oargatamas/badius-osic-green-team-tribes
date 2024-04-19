package com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;

import java.util.List;

public interface ArmyOperations {

    List<Troop> splitTroop(Troop troop1, List<Integer> distribution);
    Troop mergeTroop(Troop troop1, Troop troop2);
    Army splitArmy(Army fromArmy, Army desiredArmy);
    Army mergeArmy(Army targetArmy, List<Army> armiesToMerge);
    void removeArmy(Army armyToRemove);
}
