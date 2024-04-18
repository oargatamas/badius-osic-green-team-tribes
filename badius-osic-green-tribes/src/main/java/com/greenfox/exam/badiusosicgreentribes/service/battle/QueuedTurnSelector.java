package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

//Todo move to subpackage ( e.g. "flow")
public class QueuedTurnSelector implements TurnSelector {
    @Override
    public Troop getAttacker(Army army) { //Todo remove this implementation from here. Out of the ticket scope
        return army.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow(() -> new IllegalStateException("No sufficient troop found"));
    }

    @Override
    public Troop getDefender(Army army) { //Todo remove this implementation from here. Out of the ticket scop
        return army.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow(() -> new IllegalStateException("No sufficient troop found"));
    }

    //Todo make this method private
    public void applyDamage(Damage damage, Troop attacker, Troop defender){

    }
}
