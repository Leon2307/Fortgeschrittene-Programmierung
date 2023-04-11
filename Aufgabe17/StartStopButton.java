package Aufgabe17;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

class StartStopButton extends JButton implements Runnable {

    public StartStopButton(Color color) {
        setBackground(color);
        setBorderPainted(false);
        setFont(new Font("Arial", Font.BOLD, 25));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setOpaque(true);
        setText("Stop");
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public boolean isStart() {
        return getText().equals("Start");
    }

    public void switchText() {
        if (isStart()) {
            setText("Stop");
        } else {
            setText("Start");
        }
    }

    @Override
    public void run() {

    }

}