package com.greenfox.exam.badiusosicgreentribes.domain.models;

import java.util.List;

public class Battle {
    private BattleState state;
    private List<Turn> turns;
    private Army attacker;
    private Army defender;
}
