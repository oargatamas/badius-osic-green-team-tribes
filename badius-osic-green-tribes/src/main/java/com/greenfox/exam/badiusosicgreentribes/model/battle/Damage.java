package com.greenfox.exam.badiusosicgreentribes.model.battle;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Damage {
    private Integer NoDeadUnits;
    private Integer NoDeadTroops;
    private Integer damage;
    private Float chanceToRepost;

}
