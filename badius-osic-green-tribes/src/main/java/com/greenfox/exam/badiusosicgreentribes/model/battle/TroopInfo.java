package com.greenfox.exam.badiusosicgreentribes.model.battle;


public class TroopInfo {
    private String unit;
    private Integer quantity;
    private Integer health;

    public TroopInfo(String unit, Integer quantity, Integer health) {
        this.unit = unit;
        this.quantity = quantity;
        this.health = health;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
