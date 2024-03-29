package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.Cost;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Transaction;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer level;

    private Integer hp;

    @Enumerated(value = EnumType.STRING)
    private BuildingType type;

    @OneToMany
    private List<Transaction> transactions;

    @Embedded
    private Cost cost;

    @ManyToOne
    private Kingdom kingdom;

    public Building() {
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public Long getId() {
        return id;
    }

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Cost getCost() {
        return cost;
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
        private Kingdom kingdom;

        public Builder(){}

        public Builder kingdom(Kingdom kingdom) {
            this.kingdom = kingdom;
            return this;
        }

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
    private Building(Builder builder){
        this.name = builder.name;
        this.level = builder.level;
        this.hp = builder.hp;
        this.type = builder.type;
        this.transactions = builder.transactions;
        this.cost = builder.cost;
        this.kingdom = builder.kingdom;
    }
}
