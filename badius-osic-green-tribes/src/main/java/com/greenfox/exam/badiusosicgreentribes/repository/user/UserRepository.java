package com.greenfox.exam.badiusosicgreentribes.repository.user;

import com.greenfox.exam.badiusosicgreentribes.domain.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
