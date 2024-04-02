package com.greenfox.exam.badiusosicgreentribes.repository.transaction;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {
}
