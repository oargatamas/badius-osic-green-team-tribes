package com.greenfox.exam.badiusosicgreentribes.domain.models;

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

    public void setName(String name) {
        this.name = name;
    }

    public ArmyState getState() {
        return state;
    }

    public void setState(ArmyState state) {
        this.state = state;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public UnitStats getStats() {
        return stats;
    }

    public void setStats(UnitStats stats) {
        this.stats = stats;
    }

    public List<Troop> getTroops() {
        return troops;
    }

    public void setTroops(List<Troop> troops) {
        this.troops = troops;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }
}
