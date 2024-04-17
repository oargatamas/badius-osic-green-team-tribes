package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

public class QueuedTurnSelector implements TurnSelector {
    @Override
    public Troop getAttacker(Army army) {
        return army.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow(() -> new IllegalStateException("No sufficient troop found"));
    }

    @Override
    public Troop getDefender(Army army) {
        return army.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow(() -> new IllegalStateException("No sufficient troop found"));
    }
    public void applyDamage(Damage damage, Troop attacker, Troop defender){

    }
}
