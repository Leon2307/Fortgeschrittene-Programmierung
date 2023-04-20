package Aufgabe23;

import java.io.BufferedReader;
import java.io.*;

public class Aufgabe23 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Name der Eingabedatei: ");
        String eingabedatei = in.readLine();
        System.out.println("Name der Ausgabedatei fuer die Zahlen: ");
        String ausgabedateiZahlen = in.readLine();
        System.out.println("Name der Ausgabedatei fuer die Zeichen: ");
        String ausgabedateiZeichen = in.readLine();

        try (BufferedReader eingabe = new BufferedReader(new FileReader(eingabedatei));
                BufferedWriter ausgabeZahlen = new BufferedWriter(new FileWriter(ausgabedateiZahlen));
                BufferedWriter ausgabeZeichen = new BufferedWriter(new FileWriter(ausgabedateiZeichen));) {
            StreamTokenizer tokenizer = new StreamTokenizer(eingabe);
            tokenizer.eolIsSignificant(true);

            do {
                switch (tokenizer.nextToken()) {
                    case StreamTokenizer.TT_EOF:
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        ausgabeZahlen.write(Double.toString(Math.abs(tokenizer.nval)) + " ");
                        break;
                    case StreamTokenizer.TT_WORD:
                        ausgabeZeichen.write(tokenizer.sval + " ");
                        break;
                    case StreamTokenizer.TT_EOL:
                        ausgabeZahlen.newLine();
                        ausgabeZeichen.newLine();
                        break;
                }
            } while (true);

        }

    }
}
