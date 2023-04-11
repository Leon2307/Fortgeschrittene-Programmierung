package Aufgabe12;

import javax.swing.JButton;

public class BlinkButton extends JButton implements Runnable {
    public static String tauschText = "Hoppala";

    public BlinkButton(String text) {
        super(text);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Fehler");
            }
            String temp = tauschText;
            tauschText = getText();
            setText(temp);
        }
    }
}
