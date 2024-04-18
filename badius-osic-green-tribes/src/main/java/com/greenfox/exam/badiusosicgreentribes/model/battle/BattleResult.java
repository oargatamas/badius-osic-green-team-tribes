package com.greenfox.exam.badiusosicgreentribes.model.battle;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleResult {
    private Boolean didItWin;
    private List<Long> transactions;

}
