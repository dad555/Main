package Learning2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
    private JFrame theFrame;
    private MyPanel mainPanel;
    private JPanel innerCenterPanel, bottomPanel, topPanel, leftPanel, rightPanel;
    private JLabel topLabel;
    private JButton stop, tap, upgrade;
    private JLabel picLabel;
    private JTextArea logsArea;
    private JTextArea rightArea;
    private Date date;
    private Wealth wealth = new Wealth();

    public static void main(String[] args) {
        Game game = new Game();
        game.buildGUI();
        game.run();
    }

    public void buildGUI() {
        theFrame = new JFrame("My Second Game");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new MyPanel();

        /** BOTTOM PANEL */
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GRAY);
        stop = new JButton("Stop!");
        stop.addActionListener(new StopListener());
        bottomPanel.add(stop);

        tap = new JButton("Tap!");
        tap.addActionListener(new TapListener());
        bottomPanel.add(tap);

        upgrade = new JButton("Buy +1 upgrade (50)");
        upgrade.addActionListener(new UpgradeListener());
        bottomPanel.add(upgrade);

        /** TOP PANEL */
        topPanel = new JPanel();
        topPanel.setBackground(Color.GRAY);
        topLabel = new JLabel("JP MORGAN CHASE!!!");
        Font topLabelFont = new Font("georgia", Font.PLAIN, 48);
        topLabel.setFont(topLabelFont);
        topLabel.setForeground(Color.WHITE);
        topPanel.add(topLabel);

        /** RIGHT PANEL */

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);

        logsArea = new JTextArea(40,30);
        JScrollPane scrollPane = new JScrollPane(logsArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        logsArea.setLineWrap(true);
        rightPanel.add(scrollPane);

        /** LEFT PANEL */
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new GridBagLayout());
        JLabel deposit = new JLabel("Deposit");
        deposit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        leftPanel.add(deposit);


        JLabel summ = new JLabel("Сумreygrehredhrdehrdeма");


        leftPanel.add(summ);

        /** INNER CENTER PANEL (bank logo) */
        try {
            BufferedImage bankPic = ImageIO.read(new File("C:\\Users\\artur\\Documents\\Новая папка\\bank-1.jpg"));
            picLabel = new JLabel(new ImageIcon(bankPic));
        } catch (IOException e) {}

        innerCenterPanel = new JPanel();
        innerCenterPanel.setBackground(Color.GRAY);
        innerCenterPanel.add(picLabel);
        mainPanel.add(innerCenterPanel);

        /** MAIN FRAME */
        theFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        theFrame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        theFrame.getContentPane().add(BorderLayout.NORTH, topPanel);
        theFrame.getContentPane().add(BorderLayout.EAST, rightPanel);
        theFrame.getContentPane().add(BorderLayout.WEST, leftPanel);
        theFrame.setSize(1280,800);
        theFrame.setLocationRelativeTo(null);
        theFrame.setVisible(true);
    }

    public void run() {
        while (wealth.isAlive()) {
            theFrame.repaint();
            wealth.go();
        }
    }

    public class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            wealth.setAlive(false);
        }
    }


    public class TapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            wealth.tap(0.01);
        }
    }

    public class UpgradeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            upgrade1(1);
        }
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Font labelFont = new Font("monospaced bold", Font.PLAIN, 48);
            g.setFont(labelFont);
            String wealthString = new DecimalFormat("#$0.000").format(wealth.getWealthSize());
            g.drawString("Wealth: " + wealthString, 450, 500);
            String earningsString = new DecimalFormat("#$0.000").format(wealth.getEarnings());
            g.drawString("Earnings: " + earningsString, 450, 550);
        }
    }

    class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("C:\\Users\\artur\\Documents\\Новая папка\\bank-1.jpg"));
            } catch (IOException e) {

            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0,0, this);
        }
    }

    public void upgrade1(double d) {
        double temp = wealth.getWealthSize();
        if (temp >= 50) {
            double currentEarnings = wealth.getEarnings();
            currentEarnings += d;
            wealth.setEarnings(currentEarnings);

            double currentWealthSize = wealth.getWealthSize();
            currentWealthSize -= 50;
            wealth.setWealthSize(currentWealthSize);

            logsArea.append(getTime() + "Вы купили 1$ за 50!\n");
        } else {
            logsArea.append(getTime() + " У вас не хватает нала!!!\n");
        }
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.Y HH:mm:ss");
        return sdf.format(new Date(System.currentTimeMillis()));
    }
}


