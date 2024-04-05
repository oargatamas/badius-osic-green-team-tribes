package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;

@Entity
@Table(name = "Productions")
public class Production extends Transaction{

    private Integer quantity;

    @Enumerated(value = EnumType.STRING)
    private ProductionUnitType type;


    @JoinColumn(name = "target_kingdom")
    @ManyToOne
    private Kingdom targetKingdom;


    public Production() {
    }

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

    public Kingdom getTargetKingdom() {
        return targetKingdom;
    }

    public void setTargetKingdom(Kingdom targetKingdom) {
        this.targetKingdom = targetKingdom;
    }

    private Production(Builder builder){
        this.quantity = builder.quantity;
        this.type = builder.type;
    }
    public static class Builder{
        private Integer quantity;
        private ProductionUnitType type;
        private Kingdom targetKingdom;

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder type(ProductionUnitType type) {
            this.type = type;
            return this;
        }

        public Builder targetKingdom(Kingdom targetKingdom){
            this.targetKingdom = targetKingdom;
            return this;
        }

        public Production build(){
            return new Production(this);
        }
    }
}
