package com.artur.games.bankir;

import javax.swing.*;

public class GameInterface {
    public JLabel topLabel;
    public JPanel leftPanel1;
    public JLabel depoLabel;
    public JTextField depoSumField;
    public JTextField depoPeriodField;
    public JLabel sumLabel;
    public JLabel periodLabel;
    public JPanel leftPanel2;
    public JLabel businessLabel;
    public JRadioButton radioButton1;
    public JRadioButton radioButton2;
    public JRadioButton radioButton3;
    public JRadioButton radioButton4;
    public JTextArea businessLog;
    public JTextArea depoLog;
    public JLabel earningLabel;
    public JLabel earningsLabel2;
    public JLabel wealthLabel;
    public JLabel wealthLabel2;
    public JPanel mainPanel;
    public JButton depoButton;
    public JButton businessButton;
    public JLabel logsLabel;
    public JPanel bottomPanel;
    public JTextArea logsArea;
    public JFrame frame;

    public GameInterface() {
        frame = new JFrame("Bankir");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
