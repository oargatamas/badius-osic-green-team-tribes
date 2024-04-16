package com.greenfox.exam.badiusosicgreentribes.model.battle;

import java.util.List;

public class BattleResult {
    private Boolean didItWin;
    private List<Long> transactions;

    public BattleResult(Boolean didItWin, List<Long> transactions) {
        this.didItWin = didItWin;
        this.transactions = transactions;
    }

    public Boolean getDidItWin() {
        return didItWin;
    }

    public void setDidItWin(Boolean didItWin) {
        this.didItWin = didItWin;
    }

    public List<Long> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Long> transactions) {
        this.transactions = transactions;
    }
}
