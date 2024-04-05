package com.greenfox.exam.badiusosicgreentribes.domain.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Upgrades")
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Upgrade extends Transaction{

    @Enumerated(value = EnumType.STRING)
    private ProductionUnitType type;

    @Column(name = "target_level")
    private Integer targetLevel;

    @Column(name = "target_id")
    private Integer targetId;

}
