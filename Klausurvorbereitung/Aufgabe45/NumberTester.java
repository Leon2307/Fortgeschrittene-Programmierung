package Aufgabe45;

import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;

public class NumberTester {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        StreamTokenizer tokenizer = new StreamTokenizer(new FileReader(file));

        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (tokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {
                System.out.println("Vorsicht! Der Text enthält die Zahl " + tokenizer.nval);
                return;
            }
        }
        System.out.println("Der Text ist sauber");
    }
}
