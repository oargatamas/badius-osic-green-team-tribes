package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "Troops")
public class Troop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer position;

    private Integer quantity;

    private Integer level;

    @Embedded
    private UnitStats stats;

    @OneToOne
    private Unit unit;

    @ManyToOne
    private Army army;


}
