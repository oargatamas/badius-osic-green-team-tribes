package com.greenfox.exam.badiusosicgreentribes.service.battle;


import com.greenfox.exam.badiusosicgreentribes.domain.battle.Army;
import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BattleService {

    BattleFlow battleFlow;

    public BattleLog startBattle(Movement attacker) {
        try {
            if (attacker == null || attacker.getArmy() == null) {
                throw new IllegalArgumentException("Attacker's army cannot be null");
            }
            Army attackerArmy = attacker.getArmy();
            Army defenderArmy = attacker.getDestination().getStorage().getDefenderArmy();

            if (defenderArmy == null) {
                throw new IllegalArgumentException("Defender's army cannot be null");
            }

            BattleProperties battleProperties = battleFlow.prepare(attackerArmy, defenderArmy);

            BattleLog battlelog = battleFlow.battle(battleProperties);

            battleFlow.finalize(battlelog);

            return battlelog;
        } catch (Exception e) {
            return null;
        }
    }
}
