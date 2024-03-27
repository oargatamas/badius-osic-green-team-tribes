package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.common.Cost;

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

    public static class Builder{
        private String name;
        private String iconUrl;
        private UnitStats stats;
        private UnitType type;
        private Cost creationCost;
        private Cost upgradeCost;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder iconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public Builder stats(UnitStats stats) {
            this.stats = stats;
            return this;
        }

        public Builder type(UnitType type) {
            this.type = type;
            return this;
        }

        public Builder creationCost(Cost creationCost) {
            this.creationCost = creationCost;
            return this;
        }

        public Builder upgradeCost(Cost upgradeCost) {
            this.upgradeCost = upgradeCost;
            return this;
        }

        public Unit build(){
            return new Unit(this);
        }
    }

    private Unit (Builder builder){
        this.name = builder.name;
        this.iconUrl = builder.iconUrl;
        this.stats = builder.stats;
        this.type = builder.type;
        this.creationCost = builder.creationCost;
        this.upgradeCost = builder.upgradeCost;
    }
}