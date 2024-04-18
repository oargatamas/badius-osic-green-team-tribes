package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.TroopRepository;
import org.springframework.stereotype.Component;

@Component
public class TroopAdapter implements TroopOperations{

    TroopRepository troopRepository;

    public TroopAdapter(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    @Override
    public Transaction trainUnits(Kingdom kingdom, UnitType unit, Integer quantity) {
        return null;
    }

    @Override
    public Transaction promoteTroop(Kingdom kingdom, Troop troopToUpgrade) {
        return null;
    }
}
