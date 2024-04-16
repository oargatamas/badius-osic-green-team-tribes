package com.greenfox.exam.badiusosicgreentribes.model.battle;

import java.util.List;

public class BattleLog {
    private BattleProperties properties;
    private List<BattleTurn> turns;
    private BattleResult attackerResult;
    private BattleResult defenderResult;

    public BattleLog(BattleProperties properties, List<BattleTurn> turns, BattleResult attackerResult, BattleResult defenderResult) {
        this.properties = properties;
        this.turns = turns;
        this.attackerResult = attackerResult;
        this.defenderResult = defenderResult;
    }

    public BattleProperties getProperties() {
        return properties;
    }

    public void setProperties(BattleProperties properties) {
        this.properties = properties;
    }

    public List<BattleTurn> getTurns() {
        return turns;
    }

    public void setTurns(List<BattleTurn> turns) {
        this.turns = turns;
    }

    public BattleResult getAttackerResult() {
        return attackerResult;
    }

    public void setAttackerResult(BattleResult attackerResult) {
        this.attackerResult = attackerResult;
    }

    public BattleResult getDefenderResult() {
        return defenderResult;
    }

    public void setDefenderResult(BattleResult defenderResult) {
        this.defenderResult = defenderResult;
    }
}
