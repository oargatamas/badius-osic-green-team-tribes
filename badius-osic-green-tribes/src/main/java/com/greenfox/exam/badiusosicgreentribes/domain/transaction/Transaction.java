package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import java.sql.Timestamp;

public class Transaction {
    private String name;
    private Integer duration;
    private Timestamp startAt;
    private boolean recurring;
    private TransactionState state;

    protected Transaction(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }
    private Transaction(Builder builder){
        this.name = builder.name;
        this.duration = builder.duration;
        this.startAt = builder.startAt;
        this.recurring = builder.recurring;
        this.state = builder.state;
    }
    public static class Builder{
        private String name;
        private Integer duration;
        private Timestamp startAt;
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

        public Builder startAt(Timestamp startAt) {
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
        public Transaction build(){
            return new Transaction(this);
        }
    }
}
