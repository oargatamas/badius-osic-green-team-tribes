package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Battle {
    private BattleState state;
    private List<Turn> turns;
    private Army attacker;
    private Army defender;

}
