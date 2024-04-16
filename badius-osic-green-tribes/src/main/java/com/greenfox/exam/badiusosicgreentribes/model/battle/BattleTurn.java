package com.greenfox.exam.badiusosicgreentribes.model.battle;

public class BattleTurn {
    private TroopInfo attacker;
    private TroopInfo defender;
    private String result;

    public BattleTurn(TroopInfo attacker, TroopInfo defender, String result) {
        this.attacker = attacker;
        this.defender = defender;
        this.result = result;
    }

    public TroopInfo getAttacker() {
        return attacker;
    }

    public void setAttacker(TroopInfo attacker) {
        this.attacker = attacker;
    }

    public TroopInfo getDefender() {
        return defender;
    }

    public void setDefender(TroopInfo defender) {
        this.defender = defender;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
