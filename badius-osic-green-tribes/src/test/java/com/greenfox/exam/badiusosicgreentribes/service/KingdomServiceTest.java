package com.greenfox.exam.badiusosicgreentribes.service;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KingdomServiceTest {

    @Mock
    KingdomAdapter kingdomAdapter;
    @Mock
    BuildingAdapter buildingAdapter;
    @Mock
    ArmyAdapter armyAdapter;
    @Mock
    TroopAdapter troopAdapter;

    @InjectMocks
    KingdomService service;

    @Test
    public void testSplitTroopDelegate() {
        Troop troop1 = Troop.builder().build();
        List<Integer> distribution = List.of(2, 4, 1);
        List<Troop> troops = service.splitTroop(troop1, distribution);

        verify(armyAdapter, times(1)).splitTroop(troop1, distribution);
    }


    @Test
    public void testMergeTroopDelegate() {
        Troop troop1 = Troop.builder().build();
        Troop troop2 = Troop.builder().build();
        Troop mergeTroop = service.mergeTroop(troop1, troop2);

        verify(armyAdapter, times(1)).mergeTroop(troop1, troop2);
    }

    @Test
    public void testSplitArmyDelegate() {
        Army fromArmy = Army.builder().build();
        Army desiredArmy = Army.builder().build();
        Army army = service.splitArmy(fromArmy, desiredArmy);

        verify(armyAdapter,times(1)).splitArmy(fromArmy, desiredArmy);
    }

    @Test
    public void testMergeArmyDelegate() {
        Army targetArmy = Army.builder().build();
        List<Army> armiesToMerge = List.of(Army.builder().build());
        Army army = service.mergeArmy(targetArmy, armiesToMerge);

        verify(armyAdapter,times(1)).mergeArmy(targetArmy, armiesToMerge);
    }

    @Test
    public void testRemoveArmyDelegate() {
        Army armyToRemove = Army.builder().build();
        service.removeArmy(armyToRemove);

        verify(armyAdapter,times(1)).removeArmy(armyToRemove);
    }

    @Test
    public void testAddBuildingDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        Building buildingToAdd = Building.builder().build();
        Transaction transaction = service.addBuilding(kingdom, buildingToAdd);

        verify(buildingAdapter, times(1)).addBuilding(kingdom, buildingToAdd);
    }

    @Test
    public void testDestroyBuildingDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        Building buildingToDestroy = Building.builder().build();
        service.destroyBuilding(kingdom, buildingToDestroy);

        verify(buildingAdapter, times(1)).destroyBuilding(kingdom, buildingToDestroy);
    }

    @Test
    public void testUpgradeBuildingDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        Building buildingToUpgrade = Building.builder().build();
        Transaction transaction = service.upgradeBuilding(kingdom, buildingToUpgrade);

        verify(buildingAdapter, times(1)).upgradeBuilding(kingdom, buildingToUpgrade);
    }

    @Test
    public void testGetKingdomDelegate() {
        Long kingdomId = 42L;
        Kingdom kingdom = service.getKingdom(kingdomId);

        verify(kingdomAdapter,times(1)).getKingdom(kingdomId);
    }

    @Test
    public void testListKingdomsDelegate() {
        MapArea area = MapArea.builder().build();
        List<Kingdom> kingdoms = service.listKingdoms(area);

        verify(kingdomAdapter,times(1)).listKingdoms(area);
    }

    @Test
    public void testPlaceKingdomDelegate() {
        User user = User.builder().build();
        String kingdomName = "NeverLand";
        Kingdom kingdom = service.placeKingdom(user, kingdomName);

        verify(kingdomAdapter, times(1)).placeKingdom(user, kingdomName);
    }

    @Test
    public void testRemoveKingdomDelegate() {
        Long kingdomId = 42L;
        service.removeKingdom(kingdomId);

        verify(kingdomAdapter, times(1)).removeKingdom(kingdomId);
    }

    @Test
    public void testUpdateTreasuryDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        Production transaction = Production.builder().build();
        service.updateTreasury(kingdom, transaction);

        verify(kingdomAdapter, times(1)).updateTreasury(kingdom, transaction);
    }

    @Test
    public void testAttackKingdomDelegate() {
        Army attacker = Army.builder().build();
        Kingdom target = Kingdom.builder().build();
        Transaction transaction = service.attackKingdom(attacker, target);

        verify(kingdomAdapter, times(1)).attackKingdom(attacker, target);
    }

    @Test
    public void testTrainUnitsDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        UnitType unit = UnitType.MAGE;
        Integer quantity = 42;

        Transaction transaction = service.trainUnits(kingdom, unit, quantity);

        verify(troopAdapter, times(1)).trainUnits(kingdom, unit, quantity);
    }

    @Test
    public void testPromoteTroopDelegate() {
        Kingdom kingdom = Kingdom.builder().build();
        Troop troopToUpgrade = Troop.builder().build();

        Transaction transaction = service.promoteTroop(kingdom, troopToUpgrade);

        verify(troopAdapter, times(1)).promoteTroop(kingdom, troopToUpgrade);
    }

}
