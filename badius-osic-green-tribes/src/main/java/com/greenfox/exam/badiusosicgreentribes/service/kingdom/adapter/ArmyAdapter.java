package com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.ArmyRepository;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.ArmyOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArmyAdapter implements ArmyOperations {

    ArmyRepository armyRepository;

    public ArmyAdapter(ArmyRepository armyRepository) {
        this.armyRepository = armyRepository;
    }

    @Override
    public List<Troop> splitTroop(Troop troop1, List<Integer> distribution) {
        // TODO Implement method
        return null;
    }

    @Override
    public Troop mergeTroop(Troop troop1, Troop troop2) {
        // TODO Implement method
        return null;
    }

    @Override
    public Army splitArmy(Army fromArmy, Army desiredArmy) {
        // TODO Implement method
        return null;
    }

    @Override
    public Army mergeArmy(Army targetArmy, List<Army> armiesToMerge) {
        // TODO Implement method
        return null;
    }

    @Override
    public void removeArmy(Army armyToRemove) {
        // TODO Implement method
    }
}
