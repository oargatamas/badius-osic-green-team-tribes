package com.greenfox.exam.badiusosicgreentribes.service.battle.calculator;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

public class DamageCalculator {

    public Damage calcDamage(Troop attacker, Troop defender){

        /*
        attacker
            attack

        defender
            quantity
            unit
                health
                defense
            troop
                health
                defense

        unit_damage = att_value - def_value
        damage = (unit_damage * no_attacker)  - 2342

        50 * 200 = 10 000  -> 7658

        11 megdöglik és még 142 -et le kell írni

        38 (200/200) 1 (58/200)

        no_dead_units = damage div unit_health
         */

        Integer attackRatePerUnit = attacker.getUnit().getStats().getAttack(); // 10
        Integer defenseRatePerUnit = defender.getUnit().getStats().getDefense(); // 2
        Integer healthPerUnit = defender.getUnit().getStats().getHealth(); // 10
        Integer troopHealth = defender.getStats().getHealth(); // 12*10 = 120

        int damageRatePerUnit = attackRatePerUnit - defenseRatePerUnit; // 10 - 2 = 8

        Integer completeDamage = damageRatePerUnit * attacker.getQuantity(); // 8 * 5 = 40

        Integer noDeadUnits = completeDamage / healthPerUnit; // 40 / 10 = 4
        Integer deadUnitsHealth = noDeadUnits * healthPerUnit; // 4 * 10 = 40

        Integer remainingDamage = completeDamage - deadUnitsHealth; // 40 - 40 = 0
        Integer numberOfDeadTroops = (troopHealth - deadUnitsHealth - remainingDamage) > 0 ? 0 : 1; // 120 - 40 - 0 = 80

        /*

        Integer damage = attacker.getStats().getAttack() * attacker.getQuantity() - defender.getStats().getDefense() * defender.getQuantity();
        Integer noDeadUnits = Math.min(damage / defender.getStats().getHealth() - (defender.getStats().getHealth() - defender.getCurrentHealth()), defender.getQuantity());
        Integer noDeadTroops = Objects.equals(noDeadUnits, defender.getQuantity()) ? 1 : 0;
        damage = Objects.equals(noDeadUnits, defender.getQuantity()) ? 0 : damage % defender.getStats().getHealth();
*/

        return  Damage.builder()
                .chanceToRepost(1f)
                .damage(remainingDamage)
                .NoDeadUnits(noDeadUnits)
                .NoDeadTroops(numberOfDeadTroops)
                .build();
    }
}
