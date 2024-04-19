package com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.TroopRepository;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.TroopOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TroopAdapter implements TroopOperations {

    TroopRepository troopRepository;

    @Override
    public Transaction trainUnits(Kingdom kingdom, UnitType unit, Integer quantity) {
        // TODO Implement method
        return null;
    }

    @Override
    public Transaction promoteTroop(Kingdom kingdom, Troop troopToUpgrade) {
        // TODO Implement method
        return null;
    }
}
