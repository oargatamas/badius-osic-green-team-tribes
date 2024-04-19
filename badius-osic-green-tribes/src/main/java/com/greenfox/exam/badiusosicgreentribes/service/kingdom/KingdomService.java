package com.greenfox.exam.badiusosicgreentribes.service.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.MapArea;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KingdomService implements KingdomOperations, BuildingOperations, ArmyOperations, TroopOperations {

    KingdomAdapter kingdomAdapter;
    BuildingAdapter buildingAdapter;
    ArmyAdapter armyAdapter;
    TroopAdapter troopAdapter;

    @Override
    public List<Troop> splitTroop(Troop troop1, List<Integer> distribution) {
        return armyAdapter.splitTroop(troop1, distribution);
    }

    @Override
    public Troop mergeTroop(Troop troop1, Troop troop2) {
        return armyAdapter.mergeTroop(troop1, troop2);
    }

    @Override
    public Army splitArmy(Army fromArmy, Army desiredArmy) {
        return armyAdapter.splitArmy(fromArmy, desiredArmy);
    }

    @Override
    public Army mergeArmy(Army targetArmy, List<Army> armiesToMerge) {
        return armyAdapter.mergeArmy(targetArmy, armiesToMerge);
    }

    @Override
    public void removeArmy(Army armyToRemove) {
        armyAdapter.removeArmy(armyToRemove);
    }

    @Override
    public void updateArmy(Army armyToUpdate) {
        armyAdapter.updateArmy(armyToUpdate);
    }

    @Override
    public Transaction addBuilding(Kingdom kingdom, Building buildingToAdd) {
        return buildingAdapter.addBuilding(kingdom, buildingToAdd);
    }

    @Override
    public void destroyBuilding(Kingdom kingdom, Building buildingToDestroy) {
        buildingAdapter.destroyBuilding(kingdom, buildingToDestroy);
    }

    @Override
    public Transaction upgradeBuilding(Kingdom kingdom, Building buildingToUpgrade) {
        return buildingAdapter.upgradeBuilding(kingdom, buildingToUpgrade);
    }

    @Override
    public Kingdom getKingdom(Long id) {
        return kingdomAdapter.getKingdom(id);
    }

    @Override
    public List<Kingdom> listKingdoms(MapArea map) {
        return kingdomAdapter.listKingdoms(map);
    }

    @Override
    public Kingdom placeKingdom(User user, String name) {
        return kingdomAdapter.placeKingdom(user, name);
    }

    @Override
    public void removeKingdom(Long id) {
        kingdomAdapter.removeKingdom(id);
    }

    @Override
    public void updateTreasury(Kingdom kingdom, Production transaction) {
        kingdomAdapter.updateTreasury(kingdom, transaction);
    }

    @Override
    public Transaction attackKingdom(Army attacker, Kingdom target) {
        return kingdomAdapter.attackKingdom(attacker, target);
    }

    @Override
    public Transaction trainUnits(Kingdom kingdom, UnitType unit, Integer quantity) {
        return troopAdapter.trainUnits(kingdom, unit, quantity);
    }

    @Override
    public Transaction promoteTroop(Kingdom kingdom, Troop troopToUpgrade) {
        return troopAdapter.promoteTroop(kingdom, troopToUpgrade);
    }
}
