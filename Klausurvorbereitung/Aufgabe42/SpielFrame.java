package Aufgabe42;

import java.awt.*;
import javax.swing.*;

public class SpielFrame extends JFrame {
    private static Huetchenspiel spiel;

    public SpielFrame() {
        JLabel geldLabel = new JLabel("Geld (EUR): ", JLabel.CENTER);
        JTextField geldTextField = new JTextField("50.0");
        geldTextField.setEditable(false);
        JButton startButton = new JButton("Starte H ̈utchenspiel");
        JButton stopButton = new JButton("Stoppe H ̈utchenspiel");
        stopButton.setEnabled(false);
        JPanel jpOben = new JPanel();
        // Setzen des Layouts von jpOben auf ein GridLayout mit
        // 2 Zeilen und 2 Spalten
        jpOben.setLayout(new GridLayout(2, 2));

        // In der ersten Zeile des GridLayouts steht folgendes: Geld (EUR): 50.0 // In
        // der zweiten Zeile des GridLayouts steht links der Button zum Starten // und
        // rechts der Button zum Stoppen des Spiels.
        // Die Elemente werden entsprechend dem JPanel jpOben hinzugefu ̈gt.
        jpOben.add(geldLabel);
        jpOben.add(geldTextField);
        jpOben.add(startButton);
        jpOben.add(stopButton);

        JLabel statusLabel = new JLabel();
        add(statusLabel, BorderLayout.CENTER);
        JButton huetchen1Button = new JButton("Hu ̈tchen 1");
        huetchen1Button.setEnabled(false);
        JButton huetchen2Button = new JButton("Hu ̈tchen 2");
        huetchen2Button.setEnabled(false);
        JButton huetchen3Button = new JButton("Hu ̈tchen 3");
        huetchen3Button.setEnabled(false);
        JPanel jpUnten = new JPanel();
        // Setzen des Layouts von jpOben auf ein GridLayout mit 1 Zeile und
        // 3 Spalten und Hinzufu ̈gen der 3 Huetchen-Buttons zum JPanel jpUnten.
        jpUnten.setLayout(new GridLayout(1, 3));
        jpUnten.add(huetchen1Button);
        jpUnten.add(huetchen2Button);
        jpUnten.add(huetchen3Button);

        // Hinzuf ̈ugen der JPanels zum Frame mit BorderLayout (im Norden und Su ̈den)
        Container cp = this.getContentPane();
        cp.add(jpOben, BorderLayout.NORTH);
        cp.add(jpUnten, BorderLayout.SOUTH);
        // Hu ̈tchenspiel mit 3 H ̈utchen und 5 EUR Einsatz erzeugen
        Huetchenspiel hs = new Huetchenspiel(5.0, 3);
        // StartStopTastenLauscher erzeugen und registrieren
        StartStopTastenLauscher sstl = new StartStopTastenLauscher(startButton, stopButton, huetchen1Button,
                huetchen2Button, huetchen3Button);
        startButton.addActionListener(sstl);
        stopButton.addActionListener(sstl);
        // HuetchenTastenLauscher erzeugen und registrieren
        huetchen1Button.addActionListener(new HuetchenTastenLauscher(hs, 1, statusLabel, geldTextField));
        huetchen2Button.addActionListener(new HuetchenTastenLauscher(hs, 2, statusLabel, geldTextField));
        huetchen3Button.addActionListener(new HuetchenTastenLauscher(hs, 3, statusLabel, geldTextField));

    }

    public static void main(String[] args) {
        SpielFrame fenster = new SpielFrame();
        fenster.setTitle("Auf dem Alex in Berlin...");
        fenster.setSize(400, 200);
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
