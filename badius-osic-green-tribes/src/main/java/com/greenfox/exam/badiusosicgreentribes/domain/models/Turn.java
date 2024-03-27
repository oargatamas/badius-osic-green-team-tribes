package com.greenfox.exam.badiusosicgreentribes.domain.models;

public class Turn {
    private TurnState state;
    private String result;
    private Troop attacker;
    private Troop defender;

    public TurnState getState() {
        return state;
    }

    public void setState(TurnState state) {
        this.state = state;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Troop getAttacker() {
        return attacker;
    }

    public void setAttacker(Troop attacker) {
        this.attacker = attacker;
    }

    public Troop getDefender() {
        return defender;
    }

    public void setDefender(Troop defender) {
        this.defender = defender;
    }
}
