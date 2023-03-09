package Aufgabe1;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class MyFrame1 extends JFrame {
    public static Container contentPane;

    public MyFrame1(String title) {
        super(title);
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Button
        JButton button = new JButton("Farbe wechseln");
        button.addActionListener(new ButtonBearbeiter());
        contentPane.add(button, BorderLayout.NORTH);

        // Maus
        contentPane.addMouseListener(new MausBearbeiter());
    }

    class ButtonBearbeiter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            contentPane.setBackground(Color.BLACK);
        }
    }

    class MausBearbeiter implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            contentPane.setBackground(Color.WHITE);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        }

    }
}
