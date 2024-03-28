package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

import java.util.List;

@Embeddable
public class Storage {
    private Integer food;
    private Integer gold;
    private Army defenderArmy;
    @Transient
    private Army army;
    @Transient
    private List<Building> buildings;

    public Storage() {
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Army getDefenderArmy() {
        return defenderArmy;
    }

    public void setDefenderArmy(Army defenderArmy) {
        this.defenderArmy = defenderArmy;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public static class Builder {
        private Integer food;
        private Integer gold;
        private Army defenderArmy;
        private Army army;
        private List<Building> buildings;

        public Builder food(Integer food) {
            this.food = food;
            return this;
        }

        public Builder gold(Integer gold) {
            this.gold = gold;
            return this;
        }

        public Builder defenderArmy(Army defenderArmy) {
            this.defenderArmy = defenderArmy;
            return this;
        }

        public Builder army(Army army) {
            this.army = army;
            return this;
        }

        public Builder buildings(List<Building> buildings) {
            this.buildings = buildings;
            return this;
        }

        public Storage build(){
            return new Storage(this);
        }
    }
    private Storage (Builder builder){
        this.food = builder.food;
        this.gold = builder.gold;
        this.defenderArmy = builder.defenderArmy;
        this.army = builder.army;
        this.buildings = builder.buildings;
    }
}
