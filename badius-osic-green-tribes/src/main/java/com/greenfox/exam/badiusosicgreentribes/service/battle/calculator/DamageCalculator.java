package com.greenfox.exam.badiusosicgreentribes.service.battle.calculator;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

import java.util.Objects;

public class DamageCalculator {

    public Damage calcDamage(Troop attacker, Troop defender){

        Integer damage = attacker.getStats().getAttack() * attacker.getQuantity() - defender.getStats().getDefense() * defender.getQuantity();
        Integer noDeadUnits = Math.min(damage / defender.getStats().getHealth(), defender.getQuantity());
        Integer noDeadTroops = Objects.equals(noDeadUnits, defender.getQuantity()) ? 1 : 0;

        return  Damage.builder()
                .chanceToRepost(1f)
                .damage(damage)
                .NoDeadUnits(noDeadUnits)
                .NoDeadTroops(noDeadTroops)
                .build();
    }
}
