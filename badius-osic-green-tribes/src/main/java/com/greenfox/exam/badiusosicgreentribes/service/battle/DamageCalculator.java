package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

public class DamageCalculator {
    public Damage calcDamage(Troop attacker, Troop defender){
        int attack = attacker.getQuantity() * attacker.getUnit().getStats().getAttack();
        int defense = defender.getQuantity() * defender.getUnit().getStats().getDefense();
        int damage = Math.max(attack - defense, 0);
        int NoDeadUnits;
        int NoDeadTroops;


        return null;
    }
}
