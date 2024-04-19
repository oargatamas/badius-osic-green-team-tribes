package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter.ArmyAdapter;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter.BuildingAdapter;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter.KingdomAdapter;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.adapter.TroopAdapter;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.ArmyOperations;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.BuildingOperations;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.KingdomOperations;
import com.greenfox.exam.badiusosicgreentribes.service.kingdom.operations.TroopOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KingdomService implements KingdomOperations, BuildingOperations, ArmyOperations, TroopOperations {

    KingdomAdapter kingdomAdapter;
    BuildingAdapter buildingAdapter;
    ArmyAdapter armyAdapter;
    TroopAdapter troopAdapter;


    public KingdomService(KingdomAdapter kingdomAdapter, BuildingAdapter buildingAdapter, ArmyAdapter armyAdapter, TroopAdapter troopAdapter) {
        this.kingdomAdapter = kingdomAdapter;
        this.buildingAdapter = buildingAdapter;
        this.armyAdapter = armyAdapter;
        this.troopAdapter = troopAdapter;
    }

    @Override
    public List<Troop> splitTroop(Troop troop1, List<Integer> distribution) {
        return null;
    }

    @Override
    public Troop mergeTroop(Troop troop1, Troop troop2) {
        return null;
    }

    @Override
    public Army splitArmy(Army fromArmy, Army desiredArmy) {
        return null;
    }

    @Override
    public Army mergeArmy(Army targetArmy, List<Army> armiesToMerge) {
        return null;
    }

    @Override
    public void removeArmy(Army armyToRemove) {

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

    @Override
    public Transaction trainUnits(Kingdom kingdom, UnitType unit, Integer quantity) {
        return null;
    }

    @Override
    public Transaction promoteTroop(Kingdom kingdom, Troop troopToUpgrade) {
        return null;
    }
}
