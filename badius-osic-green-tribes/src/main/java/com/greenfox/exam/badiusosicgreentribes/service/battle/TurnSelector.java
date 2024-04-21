package com.greenfox.exam.badiusosicgreentribes.service.battle;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleTurn;
import com.greenfox.exam.badiusosicgreentribes.model.battle.TurnParticipants;

import java.util.List;
import java.util.Map;

public interface TurnSelector {

    Troop getTroop(Army army);
    TurnParticipants getAttackerDefender(Army attacker, Army defender);
}
