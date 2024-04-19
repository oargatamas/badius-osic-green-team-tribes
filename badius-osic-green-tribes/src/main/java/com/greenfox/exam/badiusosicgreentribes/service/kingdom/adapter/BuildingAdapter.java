package com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.BuildingRepository;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.BuildingOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BuildingAdapter implements BuildingOperations {

    BuildingRepository buildingRepository;


    @Override
    public Transaction addBuilding(Kingdom kingdom, Building buildingToAdd) {
        // TODO Implement method
        return null;
    }

    @Override
    public void destroyBuilding(Kingdom kingdom, Building buildingToDestroy) {
        // TODO Implement method
    }

    @Override
    public Transaction upgradeBuilding(Kingdom kingdom, Building buildingToUpgrade) {
        // TODO Implement method
        return null;
    }
}
