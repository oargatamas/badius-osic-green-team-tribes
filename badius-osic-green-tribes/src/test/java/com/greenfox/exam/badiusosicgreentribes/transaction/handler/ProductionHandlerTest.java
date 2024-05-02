package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.BuildingType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Storage;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.ProductionUnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProductionHandlerTest {

    ProductionHandler handler = new ProductionHandler();

    @Test
    void confirm_CompletedTransaction() {
        Kingdom kingdom = new Kingdom();
        Storage storage = Storage.builder()
                .gold(100)
                .food(50)
                .build();
        kingdom.setStorage(storage);
        Production transaction = Production.builder()
                .productionType(ProductionUnitType.GOLD)
                .quantity(10)
                .targetKingdom(kingdom)
                .state(TransactionState.COMPLETED)
                .build();

        handler.confirm(transaction);

        assertEquals(110, storage.getGold());
        assertEquals(50, storage.getFood());
    }

    @Test
    void confirm_NotCompletedTransaction() {
        Kingdom kingdom = new Kingdom();
        Storage storage = Storage.builder()
                .gold(100)
                .food(50)
                .build();
        kingdom.setStorage(storage);
        Production transaction = Production.builder()
                .productionType(ProductionUnitType.GOLD)
                .quantity(10)
                .targetKingdom(kingdom)
                .state(TransactionState.CANCELLED)
                .build();

        handler.confirm(transaction);

        assertEquals(100, storage.getGold());
        assertEquals(50, storage.getFood());
    }

    @Test
    void confirm_CompletedTransaction_Farm() {
        Kingdom kingdom = new Kingdom();
        Storage storage = new Storage();
        storage.setBuildings(new ArrayList<>());
        kingdom.setStorage(storage);
        Production transaction = Production.builder()
                .productionType(ProductionUnitType.FARM)
                .quantity(1)
                .targetKingdom(kingdom)
                .state(TransactionState.COMPLETED)
                .build();

        handler.confirm(transaction);

        assertTrue(kingdom.getStorage().getBuildings().stream()
                .anyMatch(building -> building.getType() == BuildingType.FARM));
    }

    @Test
    void confirm_CompletedTransaction_Knight() {
        Kingdom kingdom = new Kingdom();
        Storage storage = new Storage();
        kingdom.setStorage(storage);

        Army defenderArmy = new Army();
        List<Troop> troops = new ArrayList<>();

        Troop newTroop = new Troop();
        Unit unit = new Unit();
        unit.setType(UnitType.KNIGHT);
        newTroop.setUnit(unit);
        troops.add(newTroop);
        defenderArmy.setTroops(troops);

        storage.setDefenderArmy(defenderArmy);

        Production transaction = Production.builder()
                .productionType(ProductionUnitType.KNIGHT)
                .quantity(1)
                .targetKingdom(kingdom)
                .state(TransactionState.COMPLETED)
                .build();

        handler.confirm(transaction);

        assertTrue(kingdom.getStorage().getDefenderArmy().getTroops().stream()
                .anyMatch(troop -> troop.getUnit().getType() == UnitType.KNIGHT));
    }

    @Test
    void confirm_RecurringTransaction_ClonesTransaction() {
        Production transaction = new Production();
        transaction.setRecurring(true);

        Production clonedTransaction = handler.cloneRecurringTransaction(transaction);

        assertEquals(TransactionState.SCHEDULED, clonedTransaction.getState());
    }


    @Test
    void refund_UnsupportedOperation() {
        Production transaction = new Production();

        assertThrows(UnsupportedOperationException.class, () -> handler.refund(transaction));
    }
}

