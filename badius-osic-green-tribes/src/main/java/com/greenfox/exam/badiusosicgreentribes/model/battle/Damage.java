package com.greenfox.exam.badiusosicgreentribes.model.battle;

public class Damage {
    private Integer NoDeadUnits;
    private Integer NoDeadTroops;
    private Integer damage;
    private Float chanceToRepost;

    public Damage(Integer noDeadUnits, Integer noDeadTroops, Integer damage, Float chanceToRepost) {
        NoDeadUnits = noDeadUnits;
        NoDeadTroops = noDeadTroops;
        this.damage = damage;
        this.chanceToRepost = chanceToRepost;
    }

    public Integer getNoDeadUnits() {
        return NoDeadUnits;
    }

    public void setNoDeadUnits(Integer noDeadUnits) {
        NoDeadUnits = noDeadUnits;
    }

    public Integer getNoDeadTroops() {
        return NoDeadTroops;
    }

    public void setNoDeadTroops(Integer noDeadTroops) {
        NoDeadTroops = noDeadTroops;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Float getChanceToRepost() {
        return chanceToRepost;
    }

    public void setChanceToRepost(Float chanceToRepost) {
        this.chanceToRepost = chanceToRepost;
    }
}
