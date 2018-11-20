package com.artur.bankir;

public class Deposit {
    private double depositeSize;
    private double depositePeriod;

    public Deposit(double depositeSize, double depositePeriod) {
        this.depositeSize = depositeSize;
        this.depositePeriod = depositePeriod;
    }

    public double getDepositeSize() {
        return depositeSize;
    }

    public void setDepositeSize(double depositeSize) {
        this.depositeSize = depositeSize;
    }

    public double getDepositePeriod() {
        return depositePeriod;
    }

    public void setDepositePeriod(double depositePeriod) {
        this.depositePeriod = depositePeriod;
    }
}
