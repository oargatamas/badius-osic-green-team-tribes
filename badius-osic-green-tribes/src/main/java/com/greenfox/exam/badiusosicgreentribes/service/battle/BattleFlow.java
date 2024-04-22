package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;

public interface BattleFlow {
    BattleProperties prepare(Army attacker, Army defender);
    BattleLog battle(BattleProperties props);
    void finalize(BattleLog log);
}
