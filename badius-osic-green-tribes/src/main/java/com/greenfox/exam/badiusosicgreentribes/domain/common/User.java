package com.greenfox.exam.badiusosicgreentribes.domain.common;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.GameMap;
import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Users")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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


}
