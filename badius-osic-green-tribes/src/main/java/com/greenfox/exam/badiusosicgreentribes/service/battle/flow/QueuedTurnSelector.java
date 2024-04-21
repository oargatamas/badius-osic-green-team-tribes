package com.greenfox.exam.badiusosicgreentribes.service.battle.flow;

import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.battle.Troop;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleTurn;
import com.greenfox.exam.badiusosicgreentribes.model.battle.Damage;
import com.greenfox.exam.badiusosicgreentribes.model.battle.TurnParticipants;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QueuedTurnSelector implements TurnSelector {
    @Override
    public Troop getTroop(Army army) {
        return new Troop();
    }


    @Override
    public TurnParticipants getAttackerDefender(Army attacker, Army defender) {
        Random random = new Random();
        Troop troop1 = attacker.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow();
        Troop troop2 = defender.getTroops().stream().filter(t -> t.getQuantity() > 0).findFirst().orElseThrow();
        Integer troop1Speed = random.nextInt(100) + 1 + troop1.getStats().getSpeed();
        Integer troop2Speed = random.nextInt(100) + 1 + troop2.getStats().getSpeed();
        if (troop1Speed != troop2Speed) {
            if (troop1Speed > troop2Speed) {
                return TurnParticipants.builder().attacker(troop1).defender(troop2).build();
            }else return TurnParticipants.builder().attacker(troop2).defender(troop1).build();
        }else return getAttackerDefender(attacker, defender);
    }

}
