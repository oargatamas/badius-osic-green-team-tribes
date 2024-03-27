package com.greenfox.exam.badiusosicgreentribes.domain.models;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;

import java.util.List;

public class Building {
    private String name;
    private Integer level;
    private Integer hp;
    private BuildingType type;
    private Storage storage;
    private List<Transaction> transactions;
    private Cost cost;

    public String getName() {
        return name;
    }


    public Integer getLevel() {
        return level;
    }

    public Integer getHp() {
        return hp;
    }

    public BuildingType getType() {
        return type;
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Cost getCost() {
        return cost;
    }
    private Building(Builder builder){
        this.name = builder.name;
        this.level = builder.level;
        this.hp = builder.hp;
        this.type = builder.type;
        this.storage = builder.storage;
        this.transactions = builder.transactions;
        this.cost = builder.cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public static class Builder{
        private String name;
        private Integer level;
        private Integer hp;
        private BuildingType type;
        private Storage storage;
        private List<Transaction> transactions;
        private Cost cost;
        public Builder(){}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder level(Integer level) {
            this.level = level;
            return this;
        }

        public Builder hp(Integer hp) {
            this.hp = hp;
            return this;
        }

        public Builder type(BuildingType type) {
            this.type = type;
            return this;
        }

        public Builder storage(Storage storage) {
            this.storage = storage;
            return this;
        }

        public Builder transactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }

        public Builder cost(Cost cost) {
            this.cost = cost;
            return this;
        }
        public Building build(){
            return new Building(this);
        }
    }
}
