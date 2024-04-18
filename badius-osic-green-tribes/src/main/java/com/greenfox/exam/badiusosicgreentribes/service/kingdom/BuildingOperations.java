package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;

public interface BuildingOperations {

    Transaction addBuilding(Kingdom kingdom, Building buildingToAdd);
    void destroyBuilding(Kingdom kingdom, Building buildingToDestroy);
    Transaction upgradeBuilding(Kingdom kingdom, Building buildingToUpgrade);
}
