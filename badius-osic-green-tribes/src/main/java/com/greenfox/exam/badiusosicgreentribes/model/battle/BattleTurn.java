package com.greenfox.exam.badiusosicgreentribes.model.battle;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleTurn {
    private TroopInfo attacker;
    private TroopInfo defender;
    private String result;

}
