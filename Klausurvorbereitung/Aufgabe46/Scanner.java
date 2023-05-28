package Aufgabe46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Scanner {

    static class Schrott extends Exception {
        public Schrott(String msg) {
            super(msg);
        }
    }

    void pruefe(String dateiName) throws IOException, Schrott {
        File file = new File(dateiName);
        StreamTokenizer st = new StreamTokenizer(new FileReader(file));

        int t;
        while ((t = st.nextToken()) != st.TT_EOF) {
            if (t == st.TT_WORD) {
                throw new Schrott(st.sval);
            }
        }
        System.out.println("Die Datei enthält nur Zahlen!");
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner();
        try {
            s.pruefe("Aufgabe46/MyFile.txt");
        } catch (Schrott e) {
            e.printStackTrace();
            System.out.println("Vorsicht! Der Text enthaelt die Schrott-Zeichen " + e.getMessage());
        }
    }
}
