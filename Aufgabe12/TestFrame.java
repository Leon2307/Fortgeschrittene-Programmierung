package Aufgabe12;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class TestFrame extends JFrame {
    public TestFrame() {
        super("TestFrame");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new BlinkButton("Klausur"), BorderLayout.CENTER);
    }
}
