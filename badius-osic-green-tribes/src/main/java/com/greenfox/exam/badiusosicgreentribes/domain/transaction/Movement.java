package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;

public class Movement extends Transaction{
    private Kingdom origin;
    private Kingdom destination;

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
