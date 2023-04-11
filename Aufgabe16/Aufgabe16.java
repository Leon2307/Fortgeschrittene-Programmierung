package Aufgabe16;

import java.util.Date;

import Prog1Tools.*;;

public class Aufgabe16 {
    public static void main(String[] args) {
        System.out.println("Press enter to start");

        IOTools.readLine();

        Date startDate = new Date();
        System.out.println("Start: " + startDate);
        System.out.println("Stoppuhr anhalten mit Eingabetaste");

        ZeitThread zeitThread = new ZeitThread();
        zeitThread.start();

        IOTools.readLine();

        zeitThread.beendet = true;
        Date endDate = new Date();
        System.out.println("Ende: " + endDate);
        System.out.println("Dauer: " + (endDate.getTime() - startDate.getTime()) + " ms");

    }
}
