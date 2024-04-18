package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.repository.kingdom.BuildingRepository;
import org.springframework.stereotype.Component;

@Component
public class BuildingAdapter implements BuildingOperations {

    BuildingRepository buildingRepository;

    public BuildingAdapter(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Transaction addBuilding(Kingdom kingdom, Building buildingToAdd) {
        return null;
    }

    @Override
    public void destroyBuilding(Kingdom kingdom, Building buildingToDestroy) {

    }

    @Override
    public Transaction upgradeBuilding(Kingdom kingdom, Building buildingToUpgrade) {
        return null;
    }
}
