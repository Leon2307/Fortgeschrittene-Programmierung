package Aufgabe42;

import java.awt.event.*;
import javax.swing.*;

// Interface implementieren
public class HuetchenTastenLauscher implements ActionListener {
    private int huetchenNummer;
    private Huetchenspiel spiel;
    private JLabel statusLabel;
    private JTextField geldTextField;

    public HuetchenTastenLauscher(Huetchenspiel spiel, int huetchenNummer,
            JLabel statusLabel, JTextField geldTextField) {
        this.spiel = spiel;
        this.huetchenNummer = huetchenNummer;
        this.statusLabel = statusLabel;
        this.geldTextField = geldTextField;
    }

    public void actionPerformed(ActionEvent ae) {
        double gewinn = spiel.spieleHuetchenSpiel(huetchenNummer);
        if (gewinn >= 0)
            statusLabel.setText("Sie haben " + gewinn + " gewonnen!");
        else
            statusLabel.setText("Sie haben " + (-gewinn) + " verloren!");
        // Geldstand aus geldTextField auslesen, anpassen und neu setzen
        double geldStand = Double.parseDouble(geldTextField.getText());
        geldStand += gewinn;
        geldTextField.setText("" + geldStand);
    }
}