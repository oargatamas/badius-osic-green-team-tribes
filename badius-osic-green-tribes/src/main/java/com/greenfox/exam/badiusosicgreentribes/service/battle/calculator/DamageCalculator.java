package com.greenfox.exam.badiusosicgreentribes.service.battle.calculator;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;

public class DamageCalculator {

    public Damage calcDamage(Troop attacker, Troop defender){ //troop refers to a group of units of a given type, and the same base stats

        Integer attackRatePerUnit = attacker.getUnit().getStats().getAttack(); //raw attack damage of the attacking troop
        Integer defenseRatePerUnit = defender.getUnit().getStats().getDefense(); //defense value of the defending troop
        Integer healthPerUnit = defender.getUnit().getStats().getHealth(); //base health value of an individual unit
        Integer troopHealth = defender.getStats().getHealth(); //the total health of all units inside the troop object

        int damageRatePerUnit = Math.max(attackRatePerUnit - defenseRatePerUnit, 0); //the actual damage of an attacking unit after defense point deductions have been applied

        Integer completeDamage = damageRatePerUnit * attacker.getQuantity(); //the total damage of the combined units in the troop object after defense point deductions have been applied

        Integer noDeadUnits = Math.min(completeDamage / healthPerUnit, defender.getQuantity()); //the number of dead units
        Integer deadUnitsHealth = noDeadUnits * healthPerUnit; //the combined health of all the dead units

        Integer remainingDamage = noDeadUnits.equals(defender.getQuantity()) ? 0 : completeDamage - deadUnitsHealth; //the leftover damage that wasn't yet used to kill a unit
        Integer numberOfDeadTroops = (troopHealth - deadUnitsHealth - remainingDamage) > 0 ? 0 : 1; //the number of dead troops. This is 1 when the total damage was enough to finish off the defending troop completely

        return  Damage.builder()
                .chanceToRepost(1f)
                .damage(remainingDamage)
                .NoDeadUnits(noDeadUnits)
                .NoDeadTroops(numberOfDeadTroops)
                .build();
    }
}
