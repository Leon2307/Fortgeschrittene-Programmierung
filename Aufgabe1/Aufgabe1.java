package Aufgabe1;
import java.awt.*;
import javax.swing.JFrame;

public class Aufgabe1 {
    public static Container contentPane;

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Aufgabe 1");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        

        
    }
}