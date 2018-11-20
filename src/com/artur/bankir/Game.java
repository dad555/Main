package com.artur.bankir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    public static void main(String[] args) {
        GameInterface gui = new GameInterface();
        Earnings earnings = new Earnings(1);
        Wealth wealth = new Wealth(0);
        final Deposit[] deposit = new Deposit[4];

        gui.earningsLabel2.setText(String.valueOf(earnings.getEarningSize()));

        Thread startThread = new Thread(() -> {
            while (true) {
                try {
                    wealth.upgradeWealthSize(earnings.getEarningSize());
                    gui.wealthLabel2.setText(String.valueOf(wealth.getWealthSize()));
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        });
        startThread.start();

        gui.depoButton.addActionListener(e -> {
            double size = Double.valueOf(gui.depoSumField.getText());
            double period = Double.valueOf(gui.depoPeriodField.getText());
            deposit[0] = new Deposit(size, period);
            gui.logsArea.setText(gui.logsArea.getText() + "Вы вложили " + size + " на срок " + period + "\n");
        });
    }
}


//class Deposit implements Runnable {
//    @Override
//    public void run() {
//        Deposit deposit;
//
//        gameThread.depoButton.addActionListener(e -> {
//
//        });
//    }
//}
