package com.greenfox.exam.badiusosicgreentribes.model.battle;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleLog {
    private BattleProperties properties;
    private List<BattleTurn> turns;
    private BattleResult attackerResult;
    private BattleResult defenderResult;

}
