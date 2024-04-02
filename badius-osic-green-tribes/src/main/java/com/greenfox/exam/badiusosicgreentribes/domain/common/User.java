package com.greenfox.exam.badiusosicgreentribes.domain.common;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.GameMap;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "user_name")
    private String userName;
    
    private String email;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "is_verified")
    private Boolean isVerified;
    
    @Column(name = "password_hash")
    private String passwordHash;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    
    @Transient
    private List<Kingdom> kingdoms;
    
    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    
    @ManyToMany
    @JoinTable(
            name = "Maps_Users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "map_id"))
    private List<GameMap> maps;

    
    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public void setKingdoms(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<GameMap> getMaps() {
        return maps;
    }

    public void setMaps(List<GameMap> maps) {
        this.maps = maps;
    }

    public static class Builder{
        private Long id;
        private String userName;
        private String email;
        private String firstName;
        private String lastName;
        private Boolean isVerified;
        private String passwordHash;
        private LocalDateTime createdAt;
        private LocalDateTime lastLogin;
        private List<Kingdom> kingdoms;
        private UserRole userRole;
        private List<GameMap> maps;

        public Builder maps(List<GameMap> maps) {
            this.maps = maps;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder verified(Boolean verified) {
            isVerified = verified;
            return this;
        }

        public Builder passwordHash(String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder lastLogin(LocalDateTime lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public Builder kingdoms(List<Kingdom> kingdoms) {
            this.kingdoms = kingdoms;
            return this;
        }

        public Builder userRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User (Builder builder){
        this.id = builder.id;
        this.userName = builder.userName;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.isVerified = builder.isVerified;
        this.passwordHash = builder.passwordHash;
        this.createdAt = builder.createdAt;
        this.lastLogin = builder.lastLogin;
        this.kingdoms = builder.kingdoms;
        this.userRole = builder.userRole;
        this.maps = builder.maps;
    }
}
