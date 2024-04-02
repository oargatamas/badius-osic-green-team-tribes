package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;

import java.util.List;

public class Army {
    private String name;
    private ArmyState state;
    private Integer size;
    private UnitStats stats;
    private List<Troop> troops;
    private Kingdom kingdom;

    public String getName() {
        return name;
    }

    public ArmyState getState() {
        return state;
    }

    public Integer getSize() {
        return size;
    }

    public UnitStats getStats() {
        return stats;
    }

    public List<Troop> getTroops() {
        return troops;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(ArmyState state) {
        this.state = state;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setStats(UnitStats stats) {
        this.stats = stats;
    }

    public void setTroops(List<Troop> troops) {
        this.troops = troops;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    private Army(Builder builder){
        this.name = builder.name;
        this.state = builder.state;
        this.size = builder.size;
        this.stats = builder.stats;
        this.troops = builder.troops;
        this.kingdom = builder.kingdom;
    }

    public static class Builder{
        private String name;
        private ArmyState state;
        private Integer size;
        private UnitStats stats;
        private List<Troop> troops;
        private Kingdom kingdom;

        public Builder(){}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder state(ArmyState state) {
            this.state = state;
            return this;
        }

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder stats(UnitStats stats) {
            this.stats = stats;
            return this;
        }

        public Builder troops(List<Troop> troops) {
            this.troops = troops;
            return this;
        }

        public Builder kingdom(Kingdom kingdom) {
            this.kingdom = kingdom;
            return this;
        }
        public Army build(){
            return new Army(this);
        }
    }
}
