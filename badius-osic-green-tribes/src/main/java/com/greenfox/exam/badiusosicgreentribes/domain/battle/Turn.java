package com.greenfox.exam.badiusosicgreentribes.domain.battle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turn {
    private TurnState state;
    private String result;
    private Troop attacker;
    private Troop defender;
}
