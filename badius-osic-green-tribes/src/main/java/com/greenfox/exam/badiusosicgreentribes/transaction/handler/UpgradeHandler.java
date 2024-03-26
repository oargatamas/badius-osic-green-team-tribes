package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Upgrade;
import org.springframework.stereotype.Component;

@Component
public class UpgradeHandler implements TransactionHandler<Upgrade> {
    @Override
    public void confirm(Upgrade transaction) {
        // Todo implement method
    }
}
