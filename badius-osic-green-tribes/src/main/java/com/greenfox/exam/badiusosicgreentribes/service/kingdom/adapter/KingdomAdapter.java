package com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.KingdomRepository;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.KingdomOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class KingdomAdapter implements KingdomOperations {

    KingdomRepository kingdomRepository;

    public KingdomAdapter(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }

    @Override
    public Kingdom getKingdom(Long id) {
        return null;
    }

    @Override
    public List<Kingdom> lisKingdoms(Map map) {
        return null;
    }

    @Override
    public Kingdom placeKingdom(User user, String name) {
        return null;
    }

    @Override
    public void removeKingdom(Long id) {

    }

    @Override
    public void updateTreasury(Kingdom kingdom, Production transaction) {

    }

    @Override
    public Transaction attackKingdom(Army attacker, Kingdom target) {
        return null;
    }
}
