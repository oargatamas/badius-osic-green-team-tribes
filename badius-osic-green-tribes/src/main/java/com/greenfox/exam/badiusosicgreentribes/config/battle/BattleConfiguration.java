package com.greenfox.exam.badiusosicgreentribes.config.battle;

import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BattleConfiguration {

    @Bean
    public BattleFlow battleFlow(){
        return null;
    }

    @Bean
    public TurnSelector turnSelector(){
        return null;
    }

    @Bean
    public DamageCalculator damageCalculator(){
        return null;
    }
}
