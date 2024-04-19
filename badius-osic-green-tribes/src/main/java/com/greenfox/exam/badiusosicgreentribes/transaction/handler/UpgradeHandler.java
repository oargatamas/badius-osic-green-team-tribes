package com.greenfox.exam.badiusosicgreentribes.transaction.handler;

import com.greenfox.exam.badiusosicgreentribes.domain.transaction.Upgrade;
import com.greenfox.exam.badiusosicgreentribes.repository.transaction.UpgradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpgradeHandler implements TransactionHandler<Upgrade> {

    UpgradeRepository upgradeRepository;

    @Override
    public void confirm(Upgrade transaction) {
        // Todo implement method
    }

    @Override
    public void refund(Upgrade transaction) {
        // Todo implement method
    }
}
