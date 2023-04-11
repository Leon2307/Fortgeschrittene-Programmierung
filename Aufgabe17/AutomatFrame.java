package Aufgabe17;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AutomatFrame extends JFrame {
    ColorRunLabel label1, label2, label3;
    StartStopButton button1, button2, button3;

    public AutomatFrame() {
        super("Automat");
        Container cp = getContentPane();
        setLayout(new GridLayout(2, 3));

        label1 = new ColorRunLabel(Color.RED);
        label2 = new ColorRunLabel(Color.YELLOW);
        label3 = new ColorRunLabel(Color.GREEN);

        button1 = new StartStopButton(Color.RED);
        button2 = new StartStopButton(Color.YELLOW);
        button3 = new StartStopButton(Color.GREEN);

        AListener al = new AListener();

        button1.addActionListener(al);
        button2.addActionListener(al);
        button3.addActionListener(al);

        cp.add(label1);
        cp.add(label2);
        cp.add(label3);
        cp.add(button1);
        cp.add(button2);
        cp.add(button3);

        label1.start();
        label2.start();
        label3.start();
        button1.start();
        button2.start();
        button3.start();

    }

    class AListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                if (button1.isStart()) {
                    label1.start();
                } else {
                    label1.stop();
                }
                button1.switchText();
            } else if (e.getSource() == button2) {
                if (button2.isStart()) {
                    label2.start();
                } else {
                    label2.stop();
                }
                button2.switchText();
            } else if (e.getSource() == button3) {
                if (button3.isStart()) {
                    label3.start();
                } else {
                    label3.stop();
                }
                button3.switchText();
            }
        }
    }

}
