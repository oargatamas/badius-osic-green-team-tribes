package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Battle {
    private BattleState state;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Turn> turns;
    private Army attacker;
    private Army defender;

}
