package Aufgabe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame {
    public Container contentPane;
    public JComboBox<String> cb;
    public String[] items = {
            "Tag, Datum und Uhrzeit",
            "Datum und Uhrzeit mit Sekunden",
            "Datum mit Jahr und Uhrzeit" };
    public JLabel date;
    public JLabel text;
    public DateManager dm = new DateManager();
    public JButton refresh;
    public int cbIndex;

    public MyFrame2() {
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // Combo Box
        cb = new JComboBox<String>(items);
        AnzeigeListener al = new AnzeigeListener();
        cb.addActionListener(al);
        contentPane.add(cb, BorderLayout.NORTH);

        // Text
        text = new JLabel("Datum und Uhrzeit:");
        contentPane.add(text, BorderLayout.WEST);

        // Datumsanzeig
        dm.setDate(0);
        date = new JLabel(dm.getDate());
        contentPane.add(date, BorderLayout.EAST);

        // Aktualisierungsknopf
        refresh = new JButton("Anzeige Aktualisieren");
        KnopfHorcher kh = new KnopfHorcher(date, refresh, dm);
        refresh.addActionListener(kh);
        contentPane.add(refresh, BorderLayout.SOUTH);
    }

    private class AnzeigeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cb) {
                cbIndex = cb.getSelectedIndex();
                dm.setDate(cbIndex);
            }
        }

    }
}
