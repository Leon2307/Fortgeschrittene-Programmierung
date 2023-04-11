package Aufgabe17;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ColorRunLabel extends JLabel implements Runnable {

    public boolean running = false;

    public ColorRunLabel(Color color) {
        this.setBackground(color);
        this.setFont(new Font("Arial", Font.BOLD, 50));
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
        setOpaque(true);

    }

    public void start() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("running");
            Integer randNum = (int) (Math.random() * 10);
            setText(randNum.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
