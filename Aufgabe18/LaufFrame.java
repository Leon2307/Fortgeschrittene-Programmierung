package Aufgabe18;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class LaufFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    ColorRunButton knopf1, knopf2;
    JComboBox<String> farbenWahl;
    JCheckBox buchstabenWahl;

    public LaufFrame() {
        // Swing-Komponenten erzeugen und einf¨ugen
        knopf1 = new ColorRunButton();
        knopf2 = new ColorRunButton();

        knopf1.addActionListener(new KnopfListener(knopf1));
        knopf2.addActionListener(new KnopfListener(knopf2));

        farbenWahl = new JComboBox<String>();
        farbenWahl.addItem("graue Schrift");
        farbenWahl.addItem("schwarze Schrift");

        buchstabenWahl = new JCheckBox();

        setLayout(new FlowLayout());

        add(knopf1);
        add(knopf2);
        add(farbenWahl);
        add(buchstabenWahl);

        setTitle("Aufgabe 18");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class KnopfListener implements ActionListener {
        ColorRunButton crb;

        KnopfListener(ColorRunButton crb) {
            this.crb = crb;
        }

        public void actionPerformed(ActionEvent e) {
            // Auswahl-Index des ComboBox-Objekts bestimmen und Schrift setzen
            int i = farbenWahl.getSelectedIndex();
            switch (i) {
                case 0:
                    this.crb.setForeground(Color.gray);
                    break;
                case 1:
                    this.crb.setForeground(Color.black);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + i);
            }

            // Zustand der Checkbox bestimmen und Button-Zustand ¨andern
            boolean buchstabenZustand = buchstabenWahl.isSelected();
            this.crb.change(buchstabenZustand);

        }
    }

}