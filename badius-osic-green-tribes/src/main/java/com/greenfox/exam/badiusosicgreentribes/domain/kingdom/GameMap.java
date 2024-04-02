package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

public class GameMap {
    private String name;
    private Integer kingdomLimit;
    private Integer kingdomCount;
    private MapArea global;
    private MapArea center;

    public String getName() {
        return name;
    }

    public Integer getKingdomLimit() {
        return kingdomLimit;
    }

    public Integer getKingdomCount() {
        return kingdomCount;
    }

    public MapArea getGlobal() {
        return global;
    }
    public MapArea getCenter() {
        return center;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKingdomLimit(Integer kingdomLimit) {
        this.kingdomLimit = kingdomLimit;
    }

    public void setKingdomCount(Integer kingdomCount) {
        this.kingdomCount = kingdomCount;
    }

    public void setGlobal(MapArea global) {
        this.global = global;
    }

    public void setCenter(MapArea center) {
        this.center = center;
    }

    private GameMap(Builder builder){
        this.name = builder.name;
        this.kingdomLimit = builder.kingdomLimit;
        this.kingdomCount = builder.kingdomCount;
        this.global = builder.global;
        this.center = builder.center;
    }

    public static class Builder{
        private String name;
        private Integer kingdomLimit;
        private Integer kingdomCount;
        private MapArea global;
        private MapArea center;
        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder kingdomLimit(Integer kingdomLimit) {
            this.kingdomLimit = kingdomLimit;
            return this;
        }

        public Builder kingdomCount(Integer kingdomCount) {
            this.kingdomCount = kingdomCount;
            return this;
        }

        public Builder global(MapArea global) {
            this.global = global;
            return this;
        }

        public Builder center(MapArea center) {
            this.center = center;
            return this;
        }
        public GameMap build(){
            return new GameMap(this);
        }
    }
}
