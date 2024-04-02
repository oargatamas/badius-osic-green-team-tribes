package com.greenfox.exam.badiusosicgreentribes.domain.common;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;

import java.sql.Timestamp;
import java.util.List;

public class User {
    private Long id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isVerified;
    private String passwordHash;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private List<Kingdom> kingdoms;
    private UserRole userRole;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
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

    public static class Builder{
        private Long id;
        private String userName;
        private String email;
        private String firstName;
        private String lastName;
        private Boolean isVerified;
        private String passwordHash;
        private Timestamp createdAt;
        private Timestamp lastLogin;
        private List<Kingdom> kingdoms;
        private UserRole userRole;

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

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder lastLogin(Timestamp lastLogin) {
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
    }
}
