package com.greenfox.exam.badiusosicgreentribes.model.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurnParticipants {
    private Troop attacker;
    private Troop defender;
}
