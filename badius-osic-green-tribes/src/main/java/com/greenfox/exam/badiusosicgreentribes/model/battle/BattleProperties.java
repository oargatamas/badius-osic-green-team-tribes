package com.greenfox.exam.badiusosicgreentribes.model.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleProperties {
    private Army attackerArmy; //Todo replicate the Army into the model package (only Id, Name should be fine)
    private Army defenderArmy; //Todo replicate the Army into the model package (only Id, Name should be fine)


}
