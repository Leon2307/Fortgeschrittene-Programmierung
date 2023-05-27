package Aufgabe42;

public class Huetchenspiel {
    private double einsatz;
    private int anzahlHutechen;

    public Huetchenspiel(double einsatz, int anzahlHuetchen) {
        this.einsatz = einsatz;
        this.anzahlHutechen = anzahlHuetchen;
    }

    public double spieleHuetchenSpiel(int tipp) {
        int rand = (int) Math.floor(Math.random() * anzahlHutechen);
        double gewinn;
        if (tipp == rand) {
            gewinn = einsatz;
            return gewinn;
        } else {
            gewinn = -1 * einsatz;
            return gewinn;
        }
    }
}
