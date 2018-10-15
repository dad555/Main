package gui;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        // создаем фрейм
        JFrame frame = new JFrame();

        // создаем кнопку
        JButton button = new JButton("нижми меня");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // добавляем кнопку на панель фрейма
        frame.getContentPane().add(button);

        // присваиваем фрейму размер (в пикселях)
        frame.setSize(300,300);

        frame.setVisible(true);
    }
}
