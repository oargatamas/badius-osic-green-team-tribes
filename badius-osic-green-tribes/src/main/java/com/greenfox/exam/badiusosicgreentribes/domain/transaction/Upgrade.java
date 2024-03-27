package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

public class Upgrade extends Transaction{
    private ProductionUnitType type;
    private Integer targetLevel;
    private Integer targetId;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public ProductionUnitType getType() {
        return type;
    }

    public void setType(ProductionUnitType type) {
        this.type = type;
    }

    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }
    private Upgrade(Builder builder){
        this.type = builder.type;
        this.targetLevel = builder.targetLevel;
        this.targetId = builder.targetId;
    }
    public static class Builder{
        private ProductionUnitType type;
        private Integer targetLevel;
        private Integer targetId;

        public Builder type(ProductionUnitType type) {
            this.type = type;
            return this;
        }

        public Builder targetLevel(Integer targetLevel) {
            this.targetLevel = targetLevel;
            return this;
        }

        public Builder targetId(Integer targetId) {
            this.targetId = targetId;
            return this;
        }
        public Upgrade build(){
            return new Upgrade(this);
        }
    }
}
