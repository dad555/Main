package com.artur.games.bankir;

public class Wealth {
    private double wealthSize;

    public Wealth(double wealthSize) {
        this.wealthSize = wealthSize;
    }

    public double getWealthSize() {
        return wealthSize;
    }

    public void setWealthSize(double wealthSize) {
        this.wealthSize = wealthSize;
    }

    public void upgradeWealthSize(double upgrade) {
        this.wealthSize = wealthSize + upgrade;
    }
}
