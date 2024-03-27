package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Upgrade;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.UpgradeRepository;
import org.springframework.stereotype.Component;

@Component
public class UpgradeHandler implements TransactionHandler<Upgrade> {

    UpgradeRepository upgradeRepository;

    public UpgradeHandler(UpgradeRepository upgradeRepository) {
        this.upgradeRepository = upgradeRepository;
    }

    @Override
    public void confirm(Upgrade transaction) {
        // Todo implement method
    }
}
