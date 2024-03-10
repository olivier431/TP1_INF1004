package uqtr.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {
    public static Date getRandomDateInNextYear() {
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        var millis = new Random().nextLong(System.currentTimeMillis(), calendar.getTimeInMillis());
        return new Date(millis);
    }
}
