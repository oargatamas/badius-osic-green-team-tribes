package com.greenfox.exam.badiusosicgreentribes.config.battle;

import com.greenfox.exam.badiusosicgreentribes.service.KingdomService;
import com.greenfox.exam.badiusosicgreentribes.service.TransactionService;
import com.greenfox.exam.badiusosicgreentribes.service.battle.BattleFlow;
import com.greenfox.exam.badiusosicgreentribes.service.battle.TurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.calculator.DamageCalculator;
import com.greenfox.exam.badiusosicgreentribes.service.battle.flow.QueuedTurnSelector;
import com.greenfox.exam.badiusosicgreentribes.service.battle.flow.TurnBasedBattleFlow;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BattleConfiguration {

    @Bean
    public BattleFlow battleFlow(TransactionService transactionService, BeanFactory beanFactory, KingdomService kingdomService){
        return new TurnBasedBattleFlow(transactionService, beanFactory, kingdomService);
    }

    @Bean
    public TurnSelector turnSelector() {
        return new QueuedTurnSelector();
    }

    @Bean
    public DamageCalculator damageCalculator() {
        return new DamageCalculator();
    }
}
