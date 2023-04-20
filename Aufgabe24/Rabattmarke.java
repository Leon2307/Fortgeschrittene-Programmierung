package Aufgabe24;

import java.io.Serializable;
import java.util.Date;

public class Rabattmarke implements Serializable {
    private int rabattmarkennummer;
    private String nameBesitzer;
    private int kundennummer;
    private double rabatt;
    private Date erstellungsdatum;

    public Rabattmarke(int rabattmarkennummer, String nameBesitzer, int kundennummer, double rabatt) {
        this.rabattmarkennummer = rabattmarkennummer;
        this.nameBesitzer = nameBesitzer;
        this.kundennummer = kundennummer;
        this.rabatt = rabatt;
        this.erstellungsdatum = new Date();
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public String toString() {
        return "Rabattmarke " + rabattmarkennummer + " von " + nameBesitzer + " mit Kundennummer " + kundennummer
                + " und Rabatt " + rabatt + " erstellt am " + erstellungsdatum; 
    }
}
