package com.greenfox.exam.badiusosicgreentribes.repository.kingdom;

import com.greenfox.exam.badiusosicgreentribes.domain.kingdom.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, Long> {
}
