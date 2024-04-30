package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Unit;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Building;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.BuildingType;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.ProductionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ProductionHandler implements TransactionHandler<Production> {

    @Override
    public void confirm(Production transaction) {
        if (transaction.getState().equals(TransactionState.COMPLETED)) {

            switch (transaction.getProductionType()) {
                case GOLD:
                    transaction.getTargetKingdom().getStorage().setGold(transaction.getTargetKingdom().getStorage().getGold() + transaction.getQuantity());
                    break;
                case FOOD:
                    transaction.getTargetKingdom().getStorage().setFood(transaction.getTargetKingdom().getStorage().getFood() + transaction.getQuantity());
                    break;
                case BUILDING: // do we actually produce plain buildings?
                    break;
                case RESOURCE: // do we actually produce plain resource?
                    break;
                case UNIT: // do we actually produce plain unit?
                    break;
                case TOWNHALL:
                    transaction.getTargetKingdom().addBuilding(BuildingType.TOWNHALL, transaction.getQuantity());
                    break;
                case MINE:
                    transaction.getTargetKingdom().addBuilding(BuildingType.MINE, transaction.getQuantity());
                    break;
                case FARM:
                    transaction.getTargetKingdom().addBuilding(BuildingType.FARM, transaction.getQuantity());
                    break;
                case BARRACK:
                    transaction.getTargetKingdom().addBuilding(BuildingType.BARRACK, transaction.getQuantity());
                    break;
                case ACADEMY:
                    transaction.getTargetKingdom().addBuilding(BuildingType.ACADEMY, transaction.getQuantity());
                    break;
                case KNIGHT:
                    transaction.getTargetKingdom().addTroop(UnitType.KNIGHT, transaction.getQuantity());
                    break;
                case ROGUE:
                    transaction.getTargetKingdom().addTroop(UnitType.ROGUE, transaction.getQuantity());
                    break;
                case MAGE:
                    transaction.getTargetKingdom().addTroop(UnitType.MAGE, transaction.getQuantity());
                    break;
                case ARCHER:
                    transaction.getTargetKingdom().addTroop(UnitType.ARCHER, transaction.getQuantity());
                    break;
                case SQUIRE:
                    transaction.getTargetKingdom().addTroop(UnitType.SQUIRE, transaction.getQuantity());
                    break;
                case DIPLOMAT:
                    transaction.getTargetKingdom().addTroop(UnitType.DIPLOMAT, transaction.getQuantity());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + transaction.getProductionType());
            }
            if (transaction.isRecurring()) {
                cloneRecurringTransaction(transaction);
            }
        }
    }

    @Override
    public void refund(Production transaction) {
        throw new UnsupportedOperationException("Refund is not possible in this transaction.");
    }

    public Production cloneRecurringTransaction(Production transaction) {
        Production clonedTransaction = new Production();
        clonedTransaction.setProductionType(transaction.getProductionType());
        clonedTransaction.setQuantity(transaction.getQuantity());
        clonedTransaction.setTargetKingdom(transaction.getTargetKingdom());
        clonedTransaction.setRecurring(transaction.isRecurring());
        clonedTransaction.setStartAt(LocalDateTime.now());
        clonedTransaction.setState(TransactionState.SCHEDULED);
        return clonedTransaction;
    }
}
