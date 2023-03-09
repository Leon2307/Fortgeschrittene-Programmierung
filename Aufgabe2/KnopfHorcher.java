package Aufgabe2;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KnopfHorcher implements ActionListener {
    JLabel date;
    JButton refresh;
    DateManager dm;

    public KnopfHorcher(JLabel date, JButton refresh, DateManager dm) {
        this.date = date;
        this.refresh = refresh;
        this.dm = dm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refresh) {
            date.setText(dm.getDate());
        }
    }

}
