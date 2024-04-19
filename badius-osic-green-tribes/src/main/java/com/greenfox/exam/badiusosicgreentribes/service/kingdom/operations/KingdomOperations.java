package com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import org.springframework.transaction.TransactionDefinition;

import java.util.List;
import java.util.Map;

public interface KingdomOperations {

    Kingdom getKingdom(Long id);
    List<Kingdom> lisKingdoms(Map map);
    Kingdom placeKingdom(User user, String name);
    void removeKingdom(Long id);
    void updateTreasury(Kingdom kingdom, Production transaction);
    Transaction attackKingdom(Army attacker, Kingdom target);
}
