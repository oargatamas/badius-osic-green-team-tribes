package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

public class Production extends Transaction{
    private Integer quantity;
    private ProductionUnitType type;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductionUnitType getType() {
        return type;
    }

    public void setType(ProductionUnitType type) {
        this.type = type;
    }
    private Production(Builder builder){
        this.quantity = builder.quantity;
        this.type = builder.type;
    }
    public static class Builder{
        private Integer quantity;
        private ProductionUnitType type;

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder type(ProductionUnitType type) {
            this.type = type;
            return this;
        }
        public Production build(){
            return new Production(this);
        }
    }
}
