package com.artur.garbage.Learning2;

public class Deposit {
    private double account;
    private int days;

    public Deposit(double account, int days) {
        this.account = account;
        this.days = days;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
