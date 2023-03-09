package Aufgabe3;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.*;

import java.awt.*;

public class MyFrame3 extends JFrame {
    public Container contentPane;
    public ButtonGroup buttonGroup;
    public JRadioButton red;
    public JRadioButton yellow;
    public JRadioButton green;
    public JButton redButton;
    public JButton yellowButton;
    public JButton greenButton;

    public MyFrame3(String title) {
        super(title);
        contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 3));

        // Radio Buttons
        red = new JRadioButton("rot");
        red.setSelected(true);
        yellow = new JRadioButton("gelb");
        green = new JRadioButton("grün");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(red);
        buttonGroup.add(yellow);
        buttonGroup.add(green);

        // Buttons
        redButton = new JButton();
        redButton.setOpaque(true);
        redButton.setBackground(Color.RED);
        redButton.setBorderPainted(false);
        yellowButton = new JButton();
        yellowButton.setOpaque(true);
        yellowButton.setBorderPainted(false);
        greenButton = new JButton();
        greenButton.setOpaque(true);
        greenButton.setBorderPainted(false);

        // Listener
        ButtonListener bl = new ButtonListener();
        red.addActionListener(bl);
        yellow.addActionListener(bl);
        green.addActionListener(bl);
        redButton.addActionListener(bl);
        yellowButton.addActionListener(bl);
        greenButton.addActionListener(bl);

        contentPane.add(red);
        contentPane.add(redButton);
        contentPane.add(yellow);
        contentPane.add(yellowButton);
        contentPane.add(green);
        contentPane.add(greenButton);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == red || e.getSource() == redButton) {
                red.setSelected(true);
                redButton.setBackground(Color.RED);
                yellowButton.setBackground(Color.WHITE);
                greenButton.setBackground(Color.WHITE);
            } else if (e.getSource() == yellow || e.getSource() == yellowButton) {
                yellow.setSelected(true);
                yellowButton.setBackground(Color.YELLOW);
                redButton.setBackground(Color.WHITE);
                greenButton.setBackground(Color.WHITE);
            } else if (e.getSource() == green || e.getSource() == greenButton) {
                green.setSelected(true);
                yellowButton.setBackground(Color.WHITE);
                redButton.setBackground(Color.WHITE);
                greenButton.setBackground(Color.GREEN);
            }
        }

    }
}
