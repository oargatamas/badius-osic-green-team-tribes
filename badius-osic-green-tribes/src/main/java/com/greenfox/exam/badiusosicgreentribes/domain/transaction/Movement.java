package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

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
        this.setName(builder.name);
        this.setDuration(builder.duration);
        this.setStartAt(builder.startAt);
        this.setRecurring(builder.recurring);
        this.setState(builder.state);
    }
    public static class Builder{
        private Kingdom origin;
        private Kingdom destination;
        private String name;
        private Integer duration;
        private LocalDateTime startAt;
        private boolean recurring;
        private TransactionState state;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder duration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder startAt(LocalDateTime startAt) {
            this.startAt = startAt;
            return this;
        }

        public Builder recurring(boolean recurring) {
            this.recurring = recurring;
            return this;
        }

        public Builder state(TransactionState state) {
            this.state = state;
            return this;
        }
        
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
