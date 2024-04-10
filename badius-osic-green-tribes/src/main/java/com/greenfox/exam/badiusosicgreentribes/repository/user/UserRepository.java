package com.greenfox.exam.badiusosicgreentribes.repository.user;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import com.greenfox.exam.badiusosicgreentribes.domain.common.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findUserByEmail(String email) {
        return Optional.of(User.builder() // TODO change it to query the database!!!
                .userId(1L)
                .email(email)
                .passwordHash(BCrypt.hashpw("password",BCrypt.gensalt()))
                .userRole(UserRole.PLAYER)
                .build());
    }
}
