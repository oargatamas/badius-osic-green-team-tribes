package com.greenfox.exam.badiusosicgreentribes.domain.models;

import java.util.List;

public class Storage {
    private Integer food;
    private Integer gold;
    private Army defenderArmy;
    private Army army;
    private List<Building> buildings;

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
}
