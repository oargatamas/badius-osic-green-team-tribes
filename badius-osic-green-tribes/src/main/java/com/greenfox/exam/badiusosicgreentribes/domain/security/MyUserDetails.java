package com.greenfox.exam.badiusosicgreentribes.domain.security;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.common.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
    private boolean active;
    private UserRole authorities;

    public MyUserDetails(User user){
        this.userName = user.getUserName();
        this.password = user.getPasswordHash();
        this.authorities = user.getUserRole();
    }
    public MyUserDetails(){

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("PLAYER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
