package com.greenfox.exam.badiusosicgreentribes.service.battle;


import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Movement;
import com.greenfox.exam.badiusosicgreentribes.model.battle.BattleLog;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    public BattleLog startBattle(Movement attacker){
        return new BattleLog();
    }
}
