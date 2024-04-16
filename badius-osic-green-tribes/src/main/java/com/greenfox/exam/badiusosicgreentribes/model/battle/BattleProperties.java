package com.greenfox.exam.badiusosicgreentribes.model.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleProperties {
    private Army attackerArmy;
    private Army defenderArmy;


}
