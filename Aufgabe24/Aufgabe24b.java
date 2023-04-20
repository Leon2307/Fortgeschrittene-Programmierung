package Aufgabe24;

import java.io.*;

public class Aufgabe24b {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Aufgabe24/Rabattmarken.dat"));
        System.out.println("Anzahl der Rabattmarken: ");
        int anzahl = Integer.parseInt(in.readLine());
        Rabattmarke[] rabattmarken = new Rabattmarke[anzahl];
        for (int i = 0; i < anzahl; i++) {
            System.out.println("Rabattmarke " + (i + 1) + ": ");
            System.out.println("Name des Besitzers: ");
            String nameBesitzer = in.readLine();
            System.out.println("Kundennummer: ");
            int kundennummer = Integer.parseInt(in.readLine());
            System.out.println("Rabatt: ");
            double rabatt = Double.parseDouble(in.readLine());

            rabattmarken[i] = new Rabattmarke(i + 1, nameBesitzer, kundennummer, rabatt);
            out.writeObject(rabattmarken[i]);
        }
        out.close();
        in.close();


    }
}
