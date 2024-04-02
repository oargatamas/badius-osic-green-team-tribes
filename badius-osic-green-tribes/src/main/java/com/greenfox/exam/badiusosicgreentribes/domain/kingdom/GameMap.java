package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Maps")
public class GameMap {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer kingdomLimit;

    private Integer kingdomCount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "width", column = @Column(name = "global_width")),
            @AttributeOverride(name = "height", column = @Column(name = "global_height")),
            @AttributeOverride(name = "top", column = @Column(name = "global_top")),
            @AttributeOverride(name = "left", column = @Column(name = "global_left")),
    })
    private MapArea global;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "width", column = @Column(name = "center_width")),
            @AttributeOverride(name = "height", column = @Column(name = "center_height")),
            @AttributeOverride(name = "top", column = @Column(name = "center_top")),
            @AttributeOverride(name = "left", column = @Column(name = "center_left")),
    })
    private MapArea center;

    @ManyToMany(mappedBy = "maps")
    private List<User> users;

    public GameMap() {
    }

    public String getName() {
        return name;
    }

    public Integer getKingdomLimit() {
        return kingdomLimit;
    }

    public Integer getKingdomCount() {
        return kingdomCount;
    }

    public MapArea getGlobal() {
        return global;
    }
    public MapArea getCenter() {
        return center;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKingdomLimit(Integer kingdomLimit) {
        this.kingdomLimit = kingdomLimit;
    }

    public void setKingdomCount(Integer kingdomCount) {
        this.kingdomCount = kingdomCount;
    }

    public void setGlobal(MapArea global) {
        this.global = global;
    }

    public void setCenter(MapArea center) {
        this.center = center;
    }

    public Long getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private GameMap(Builder builder){
        this.name = builder.name;
        this.kingdomLimit = builder.kingdomLimit;
        this.kingdomCount = builder.kingdomCount;
        this.global = builder.global;
        this.center = builder.center;
        this.users = builder.users;
    }

    public static class Builder{
        private String name;
        private Integer kingdomLimit;
        private Integer kingdomCount;
        private MapArea global;
        private MapArea center;
        private List<User> users;

        public Builder users(List<User> users) {
            this.users = users;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder kingdomLimit(Integer kingdomLimit) {
            this.kingdomLimit = kingdomLimit;
            return this;
        }

        public Builder kingdomCount(Integer kingdomCount) {
            this.kingdomCount = kingdomCount;
            return this;
        }

        public Builder global(MapArea global) {
            this.global = global;
            return this;
        }

        public Builder center(MapArea center) {
            this.center = center;
            return this;
        }
        public GameMap build(){
            return new GameMap(this);
        }
    }
}
