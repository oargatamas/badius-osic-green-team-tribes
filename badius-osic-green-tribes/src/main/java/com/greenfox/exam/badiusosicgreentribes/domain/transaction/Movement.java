package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movements")
public class Movement extends Transaction{

    @ManyToOne
    private Kingdom origin;

    @ManyToOne
    private Kingdom destination;

    public Movement() {

    }

    public Kingdom getOrigin() {
        return origin;
    }

    public void setOrigin(Kingdom origin) {
        this.origin = origin;
    }

    public Kingdom getDestination() {
        return destination;
    }

    public void setDestination(Kingdom destination) {
        this.destination = destination;
    }
    private Movement(Builder builder){
        this.origin =builder.origin;
        this.destination = builder.destination;
    }
    public static class Builder{
        private Kingdom origin;
        private Kingdom destination;
        public Builder origin(Kingdom origin){
            this.origin = origin;
            return this;
        }
        public Builder destination(Kingdom destination){
            this.destination = destination;
            return this;
        }
        public Movement build(){
            return new Movement(this);
        }
    }
}
