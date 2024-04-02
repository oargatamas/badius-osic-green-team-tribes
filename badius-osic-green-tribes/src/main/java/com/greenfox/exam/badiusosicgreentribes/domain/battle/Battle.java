package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import jakarta.persistence.Entity;

import java.util.List;

public class Battle {
    private BattleState state;
    private List<Turn> turns;
    private Army attacker;
    private Army defender;

    public BattleState getState() {
        return state;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public Army getAttacker() {
        return attacker;
    }

    public Army getDefender() {
        return defender;
    }

    public void setState(BattleState state) {
        this.state = state;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    public void setAttacker(Army attacker) {
        this.attacker = attacker;
    }

    public void setDefender(Army defender) {
        this.defender = defender;
    }

    private Battle(Builder builder){
        this.state = builder.state;
        this.attacker = builder.attacker;
        this.defender = builder.defender;
        this.turns = builder.turns;
    }
    public static class Builder{
        private BattleState state;
        private List<Turn> turns;
        private Army attacker;
        private Army defender;
        public Builder(){}

        public Builder state(BattleState state) {
            this.state = state;
            return this;
        }

        public Builder turns(List<Turn> turns) {
            this.turns = turns;
            return this;
        }

        public Builder attacker(Army attacker) {
            this.attacker = attacker;
            return this;
        }

        public Builder defender(Army defender) {
            this.defender = defender;
            return this;
        }
        public Battle build(){
            return new Battle(this);
        }
    }
}
