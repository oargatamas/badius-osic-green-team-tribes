package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.UnitType;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.BuildingType;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.TransactionState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ProductionHandler implements TransactionHandler<Production> {

    @Override
    public void confirm(Production transaction) {

        switch (transaction.getProductionType().getCategory()) {

            case BUILDING:
                BuildingType buildingType = BuildingType.valueOf(transaction.getProductionType().name());
                transaction.getTargetKingdom().addBuilding(buildingType, transaction.getQuantity());
                break;
            case GOLD:
                transaction.getTargetKingdom().getStorage().setGold(transaction.getTargetKingdom().getStorage().getGold() + transaction.getQuantity());
                break;
            case FOOD:
                transaction.getTargetKingdom().getStorage().setFood(transaction.getTargetKingdom().getStorage().getFood() + transaction.getQuantity());
                break;
            case UNIT:
                UnitType unitType = UnitType.valueOf(transaction.getProductionType().name());
                transaction.getTargetKingdom().addTroop(unitType, transaction.getQuantity());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + transaction.getProductionType());
        }
        if (transaction.isRecurring()) {
            cloneRecurringTransaction(transaction);
        }
    }

    @Override
    public void refund(Production transaction) {
        throw new UnsupportedOperationException("Refund is not possible in this transaction.");
    }

    public Production cloneRecurringTransaction(Production transaction) {
        Production clonedTransaction = Production.builder()
                .productionType(transaction.getProductionType())
                .quantity(transaction.getQuantity())
                .targetKingdom(transaction.getTargetKingdom())
                .recurring(transaction.isRecurring())
                .startAt(LocalDateTime.now())
                .state(TransactionState.SCHEDULED)
                .build();
        return clonedTransaction;
    }
}
