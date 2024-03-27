package com.greenfox.exam.badiusosicgreentribes.domain.models;

public class Unit {
    private String name;
    private String iconUrl;
    private UnitStats stats;
    private UnitType type;
    private Cost creationCost;
    private Cost upgradeCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public UnitStats getStats() {
        return stats;
    }

    public void setStats(UnitStats stats) {
        this.stats = stats;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(UnitType type) {
        this.type = type;
    }

    public Cost getCreationCost() {
        return creationCost;
    }

    public void setCreationCost(Cost creationCost) {
        this.creationCost = creationCost;
    }

    public Cost getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(Cost upgradeCost) {
        this.upgradeCost = upgradeCost;
    }
}
