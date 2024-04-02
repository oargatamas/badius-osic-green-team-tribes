package com.greenfox.exam.badiusosicgreentribes.domain.battle;

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
    public static class Builder{

        private TurnState state;
        private String result;
        private Troop attacker;
        private Troop defender;

        public Builder state(TurnState state) {
            this.state = state;
            return this;
        }

        public Builder result(String result) {
            this.result = result;
            return this;
        }

        public Builder attacker(Troop attacker) {
            this.attacker = attacker;
            return this;
        }

        public Builder defender(Troop defender) {
            this.defender = defender;
            return this;
        }

        public Turn build() {
            return new Turn(this);
        }
    }

    private Turn(Builder builder) {
        this.state = builder.state;
        this.result = builder.result;
        this.attacker = builder.attacker;
        this.defender = builder.defender;
    }
}
