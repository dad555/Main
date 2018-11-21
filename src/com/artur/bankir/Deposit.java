package com.artur.bankir;

public class Deposit {
    private double depositeSize;
    private int depositePeriod;

    public Deposit(double depositeSize, int depositePeriod) {
        this.depositeSize = depositeSize;
        this.depositePeriod = depositePeriod;
    }

    public double getDepositeSize() {
        return depositeSize;
    }
    public void setDepositeSize(double depositeSize) {
        this.depositeSize = depositeSize;
    }
    public int getDepositePeriod() {
        return depositePeriod;
    }
    public void setDepositePeriod(int depositePeriod) {
        this.depositePeriod = depositePeriod;
    }

    public double calcDeposit() {
        return (depositeSize * 0.02) * depositePeriod;
    }
}
