package Aufgabe2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateManager {
    String date;
    SimpleDateFormat dateFormat0 = new SimpleDateFormat("EE, dd. MMMM, kk:mm", new Locale("de"));
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd. MMMM, kk:mm:ss", new Locale("de"));
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd.MM.YYYY (kk:mm)", new Locale("de"));

    public void setDate(int type) {
        switch (type) {
            case 0:
                date = dateFormat0.format(new Date());
                break;
            case 1:
                date = dateFormat1.format(new Date());
                break;
            case 2:
                date = dateFormat2.format(new Date());
                break;
        }
    }

    public String getDate() {
        return date;
    }
}
