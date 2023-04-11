package Aufgabe16;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ZeitThread extends Thread {

    public boolean beendet = false;

    public void run() {
        while (!beendet) {
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
            System.out.println(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
