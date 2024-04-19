package com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.MapArea;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.KingdomOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class KingdomAdapter implements KingdomOperations {

    KingdomRepository kingdomRepository;


    @Override
    public Kingdom getKingdom(Long id) {
        // TODO Implement method
        return null;
    }

    @Override
    public List<Kingdom> lisKingdoms(MapArea map) {
        // TODO Implement method
        return null;
    }

    @Override
    public Kingdom placeKingdom(User user, String name) {
        // TODO Implement method
        return null;
    }

    @Override
    public void removeKingdom(Long id) {
        // TODO Implement method
    }

    @Override
    public void updateTreasury(Kingdom kingdom, Production transaction) {
        // TODO Implement method
    }

    @Override
    public Transaction attackKingdom(Army attacker, Kingdom target) {
        // TODO Implement method
        return null;
    }
}
