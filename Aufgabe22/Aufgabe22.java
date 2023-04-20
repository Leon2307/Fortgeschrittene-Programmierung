package Aufgabe22;

import java.io.*;

public class Aufgabe22 {

    public static void main(String[] args) throws IOException {
        // Lese den Dateinamen, eine Zeilennummer und eine Textzeile ein
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Dateiname: ");
        String dateiname = in.readLine();
        System.out.print("Zeilennummer: ");
        int zeilennummer = Integer.parseInt(in.readLine());
        System.out.print("Textzeile: ");
        String textzeile = in.readLine();

        try (// Lese die ersten n-1 Zeile der Original-Datei in eine temporäre Datei namens
             // BlaBla.txt
                BufferedReader originalDateiReader = new BufferedReader(new FileReader("Aufgabe22/OriginalDatei.txt"));
                BufferedWriter blablaWriter = new BufferedWriter(new FileWriter("Aufgabe22/BlaBla.txt"));
                ) {
            if (zeilennummer <= 0) {
                zeilennummer = 1;
            }
            // Schreibe die Zeilen n-1 in die temporäre Datei
            for (int i = 1; i < zeilennummer; i++) {
                String z;
                if ((z = originalDateiReader.readLine()) == null) {
                    break;
                }
                blablaWriter.write(z);
                blablaWriter.newLine();
            }
            // Schreibe die neue Zeile in die temporäre Datei
            blablaWriter
                    .write("dateiname: " + dateiname + " zeilennummer: " + zeilennummer + " textzeile: " + textzeile);
            blablaWriter.newLine();
            // Schreibe die restlichen Zeilen in die temporäre Datei
            String c;
            while ((c = originalDateiReader.readLine()) != null) {
                blablaWriter.write(c);
                blablaWriter.newLine();
            }
            blablaWriter.flush();
            originalDateiReader.close();
            blablaWriter.close();
            
            BufferedWriter originalDateiWriter = new BufferedWriter(new FileWriter("Aufgabe22/OriginalDatei.txt"));
            BufferedReader blablaReader = new BufferedReader(new FileReader("Aufgabe22/BlaBla.txt"));
            // Schreibe die Zeilen der temporären Datei in die Original-Datei
            while ((c = blablaReader.readLine()) != null) {
                originalDateiWriter.write(c);
                originalDateiWriter.newLine();
            }
            originalDateiWriter.flush();
            originalDateiWriter.close();
            blablaReader.close();

        }

    }

}
