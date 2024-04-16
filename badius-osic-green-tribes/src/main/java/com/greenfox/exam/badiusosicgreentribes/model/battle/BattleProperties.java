package com.greenfox.exam.badiusosicgreentribes.model.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;

public class BattleProperties {
    private Army attackerArmy;
    private Army defenderArmy;

    public BattleProperties(Army attackerArmy, Army defenderArmy) {
        this.attackerArmy = attackerArmy;
        this.defenderArmy = defenderArmy;
    }

    public Army getAttackerArmy() {
        return attackerArmy;
    }

    public void setAttackerArmy(Army attackerArmy) {
        this.attackerArmy = attackerArmy;
    }

    public Army getDefenderArmy() {
        return defenderArmy;
    }

    public void setDefenderArmy(Army defenderArmy) {
        this.defenderArmy = defenderArmy;
    }
}
