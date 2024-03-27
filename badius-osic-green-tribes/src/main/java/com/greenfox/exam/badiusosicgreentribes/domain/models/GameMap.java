package com.greenfox.exam.badiusosicgreentribes.domain.models;

public class GameMap {
    private String name;
    private Integer kingdomLimit;
    private Integer kingdomCount;
    private MapArea global;
    private MapArea center;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKingdomLimit() {
        return kingdomLimit;
    }

    public void setKingdomLimit(Integer kingdomLimit) {
        this.kingdomLimit = kingdomLimit;
    }

    public Integer getKingdomCount() {
        return kingdomCount;
    }

    public void setKingdomCount(Integer kingdomCount) {
        this.kingdomCount = kingdomCount;
    }

    public MapArea getGlobal() {
        return global;
    }

    public void setGlobal(MapArea global) {
        this.global = global;
    }

    public MapArea getCenter() {
        return center;
    }

    public void setCenter(MapArea center) {
        this.center = center;
    }
}
