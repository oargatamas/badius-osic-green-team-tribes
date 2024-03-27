package com.greenfox.exam.badiusosicgreentribes.domain.battle;

public class UnitStats {
    private Integer attack;
    private Integer defense;
    private Integer health;
    private Float aggressivity;
    private Integer charisma;
    private Integer speed;

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Float getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(Float aggressivity) {
        this.aggressivity = aggressivity;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public static class Builder {
        private Integer attack;
        private Integer defense;
        private Integer health;
        private Float aggressivity;
        private Integer charisma;
        private Integer speed;

        public Builder attack(Integer attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(Integer defense) {
            this.defense = defense;
            return this;
        }

        public Builder health(Integer health) {
            this.health = health;
            return this;
        }

        public Builder aggressivity(Float aggressivity) {
            this.aggressivity = aggressivity;
            return this;
        }

        public Builder charisma(Integer charisma) {
            this.charisma = charisma;
            return this;
        }

        public Builder speed(Integer speed) {
            this.speed = speed;
            return this;
        }

        public UnitStats build(){
            return new UnitStats(this);
        }
    }

    private UnitStats (Builder builder){
        this.attack = builder.attack;
        this.defense = builder.defense;
        this. health = builder.health;
        this.aggressivity = builder.aggressivity;
        this.charisma = builder.charisma;
        this.speed = builder.speed;
    }
}
