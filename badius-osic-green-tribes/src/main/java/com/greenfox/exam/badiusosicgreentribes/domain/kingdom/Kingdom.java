package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import jakarta.persistence.*;

@Entity
@Table (name = "Kingdoms")
public class Kingdom {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ownerName;
    private Integer coordinateX;
    private Integer coordinateY;
    @ManyToOne
    private User owner;
    @ManyToOne
    private GameMap map;
    @Embedded
    private Storage storage;

    public Kingdom() {
    }

    public Long getId() {
        return id;
    }

    public static class Builder{
        private String name;
        private String ownerName;
        private Integer coordinateX;
        private Integer coordinateY;
        private User owner;
        private GameMap map;
        private Storage storage;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder coordinateX(Integer coordinateX) {
            this.coordinateX = coordinateX;
            return this;
        }

        public Builder coordinateY(Integer coordinateY) {
            this.coordinateY = coordinateY;
            return this;
        }

        public Builder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public Builder map(GameMap map) {
            this.map = map;
            return this;
        }

        public Builder storage(Storage storage) {
            this.storage = storage;
            return this;
        }

        public Kingdom build() {
            return new Kingdom(this);
        }
    }

    private Kingdom (Builder builder){
        this.name = builder.name;
        this.ownerName = builder.ownerName;
        this.coordinateX = builder.coordinateX;
        this.coordinateY = builder.coordinateY;
        this.owner = builder.owner;
        this.map = builder.map;
        this.storage = builder.storage;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
