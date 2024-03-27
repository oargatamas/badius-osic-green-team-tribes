package com.greenfox.exam.badiusosicgreentribes.domain.common;

public class Cost {
    private Integer duration;
    private Integer food;
    private Integer gold;

    public Integer getDuration() {
        return duration;
    }

    public Integer getFood() {
        return food;
    }

    public Integer getGold() {
        return gold;
    }
    private Cost(Builder builder){
        this.duration = builder.duration;
        this.food = builder.food;
        this.gold = builder.gold;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public static class Builder{
        private Integer duration;
        private Integer food;
        private Integer gold;

        public Builder duration(Integer duration){
            this.duration = duration;
            return this;
        }
        public Builder gold(Integer gold){
            this.gold = gold;
            return this;
        }
        public Builder food(Integer food){
            this.food = food;
            return this;
        }
        public Cost build(){
            return new Cost(this);
        }
    }
}
