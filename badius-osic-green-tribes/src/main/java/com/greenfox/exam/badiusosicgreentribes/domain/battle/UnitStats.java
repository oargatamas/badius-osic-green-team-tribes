package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitStats {

    @Column (name = "stat_attack")
    private Integer attack;
    @Column (name = "stat_defense")
    private Integer defense;
    @Column (name = "stat_health")
    private Integer health;
    @Column (name = "stat_aggressivity")
    private Float aggressivity;
    @Column (name = "stat_charisma")
    private Integer charisma;
    @Column (name = "stat_speed")
    private Integer speed;

}
