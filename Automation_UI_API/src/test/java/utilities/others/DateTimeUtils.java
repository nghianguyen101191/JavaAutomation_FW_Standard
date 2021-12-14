package utilities.others;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class DateTimeUtils {

    public static String getCurrentTime(String timeFormat) {
        return new SimpleDateFormat(timeFormat).format(Calendar.getInstance().getTime());
    }


    public String returenCurrentDateAndTime() {
        Date date = Calendar.getInstance().getTime();
        return date.toString();
    }


    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd_HH:mm:ss"); // dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }


    public static String getCurrentTimezone() {
        Calendar now = Calendar.getInstance();
        TimeZone timeZone = now.getTimeZone();
        // System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
        return timeZone.getDisplayName();
    }



}
