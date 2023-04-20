package Aufgabe24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Aufgabe24c {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Aufgabe24/Rabattmarken.dat"));
        try {
            while (true) {
                Rabattmarke rabattmarke = (Rabattmarke) in.readObject();
                System.out.println(rabattmarke);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ende der Datei erreicht");
        } finally {
            in.close();

        }
    }
}
