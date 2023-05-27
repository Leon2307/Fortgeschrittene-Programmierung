package Aufgabe42;

import java.awt.event.*;
import javax.swing.*;

// Interface implementieren
public class StartStopTastenLauscher implements ActionListener {
    private JButton startButton, stopButton,
            huetchen1Button, huetchen2Button, huetchen3Button;

    public StartStopTastenLauscher(JButton startB, JButton stopB,
            JButton h1B, JButton h2B, JButton h3B) {
        this.startButton = startB;
        this.stopButton = stopB;
        this.huetchen1Button = h1B;
        this.huetchen2Button = h2B;
        this.huetchen3Button = h3B;
    }

    public void actionPerformed(ActionEvent ae) {
       // Quelle des Events bestimmen
       JButton jb = (JButton) ae.getSource();
       boolean trueOrFalse = (jb == startButton);
       startButton.setEnabled(!trueOrFalse);
       stopButton.setEnabled(trueOrFalse);
       huetchen1Button.setEnabled(trueOrFalse);
       huetchen2Button.setEnabled(trueOrFalse);
       huetchen3Button.setEnabled(trueOrFalse);
     }
}
