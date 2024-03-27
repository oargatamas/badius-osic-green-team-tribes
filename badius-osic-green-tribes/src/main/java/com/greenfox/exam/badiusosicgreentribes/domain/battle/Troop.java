package com.greenfox.exam.badiusosicgreentribes.domain.battle;

public class Troop {
    private Integer position;
    private Integer quantity;
    private Integer level;
    private UnitStats stats;
    private Unit unit;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public UnitStats getStats() {
        return stats;
    }

    public void setStats(UnitStats stats) {
        this.stats = stats;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public static class Builder {
        private Integer position;
        private Integer quantity;
        private Integer level;
        private UnitStats stats;
        private Unit unit;

        public Builder position(Integer position) {
            this.position = position;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public Builder stats(UnitStats stats) {
            this.stats = stats;
            return this;
        }

        public Builder unit(Unit unit) {
            this.unit = unit;
            return this;
        }

        public Troop build() {
            return new Troop(this);
        }
    }

    private Troop (Builder builder){
        this.position = builder.position;
        this.quantity = builder.quantity;
        this.level = builder.level;
        this.stats = builder.stats;
        this.unit = builder.unit;
    }

}
