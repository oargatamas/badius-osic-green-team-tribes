package com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.MapArea;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;

import java.util.List;

public interface KingdomOperations {

    Kingdom getKingdom(Long id);
    List<Kingdom> lisKingdoms(MapArea map);
    Kingdom placeKingdom(User user, String name);
    void removeKingdom(Long id);
    void updateTreasury(Kingdom kingdom, Production transaction);
    Transaction attackKingdom(Army attacker, Kingdom target);
}
