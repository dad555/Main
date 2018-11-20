package com.artur.learning2;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JPanel leftPanel;
    private JLabel topLabel;
    private JLabel leftLabel;
    private JButton leftButton;
    private JPanel mainPanel;
    private JPanel topPanel;

    public Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void buildGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2,  -1, -1));
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 1, -1, -1));
        mainPanel.add(leftPanel, new GridBagConstraints(1, 1, 0, 1, 1, 3, 2, 1, new Insets(1,1,1,1), 1, 1));
    }
}
