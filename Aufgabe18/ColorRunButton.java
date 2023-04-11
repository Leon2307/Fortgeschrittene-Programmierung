package Aufgabe18;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ColorRunButton extends JButton implements Runnable {
    private boolean running = false; // Thread läuft zu Beginn nicht
    private boolean zeigtBuchstabe = true; // Anzeige zeigt zu Beginn Buchstaben

    public ColorRunButton() {
        setBackground(Color.white);
        setFont(new Font("Arial", Font.BOLD, 50));
        setText(" ");
    }

    public void change(boolean zeigtBuchstabe) {
        this.zeigtBuchstabe = zeigtBuchstabe;
        // Falls der Thread läuft, beende ihn mittels des running-Flags,
        // andernfalls, setze running-Flag, erzeuge neuen Thread und starte ihn
        if (running) {
            running = false;
        } else {
            running = true;
            Thread t = new Thread(this);
            t.start();
        }
    }

    public void run() {
        while (running) {
            // Berechne Zufalls-Ziffer oder Zufalls-Buchstabe
            // und setze das Zeichen als Beschriftung des Buttons
            int randInt = (int) (Math.random() * 10);
            char randChar;
            if (zeigtBuchstabe) {
                randChar = (char) (65 + randInt);
                setText("" + randChar);
            } else {
                setText("" + randInt);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}