package com.artur.bankir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
    public static void main(String[] args) {
        GameInterface gui = new GameInterface();
        Earnings earnings = new Earnings(1.01);
        Wealth wealth = new Wealth(0);
        final Deposit[] deposit = new Deposit[4];

        String earningsString = new DecimalFormat("#$0.00").format(earnings.getEarningSize());
        gui.earningsLabel2.setText(String.valueOf(earningsString));

        Thread startThread = new Thread(() -> {
            while (true) {
                try {
                    wealth.upgradeWealthSize(earnings.getEarningSize());
                    String wealthString = new DecimalFormat("#$0.00").format(wealth.getWealthSize());
                    gui.wealthLabel2.setText(String.valueOf(wealthString));
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        });
        startThread.start();

        gui.depoButton.addActionListener(e -> {
            double size = Double.valueOf(gui.depoSumField.getText());
            int period = Integer.valueOf(gui.depoPeriodField.getText());
            final double[] revenue = new double[1];
            deposit[0] = new Deposit(size, period);
            wealth.setWealthSize(wealth.getWealthSize() - size);
            gui.logsArea.setText(getTime() + gui.logsArea.getText() + " Вы вложили " + size + "$ на срок " + period + " ч. \n");
            Thread depoThread = new Thread(() -> {
                try {
                    Thread.sleep(3600000);
                    revenue[0] = deposit[0].calcDeposit();
                    gui.logsArea.setText(gui.logsArea.getText() + getTime() + " Срок депозита окончен. Вы заработали " + (revenue[0] + size) + " $ \n");
                } catch (Exception e1) {}
            });
            depoThread.start();
        });
    }

    public static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.Y HH:mm:ss");
        return sdf.format(new Date(System.currentTimeMillis()));
    }
}
