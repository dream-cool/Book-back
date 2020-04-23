package com.clt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author ：clt
 * @Date ：Created in 18:58 2020/02/25
 */
public class DateUtils {
    private DateUtils(){}

    public static final String DAY = "DAY";

    public static final String MONTH = "MONTH";

    public static final String YEAR = "YEAR";

    public static final long FIVE_MINUTE = 300 * 1000;

    public static final long oneDay = 86400000L;

    public static long daysToTimestamp(long days){
        return days * 24 * 3600 * 1000;
    }

    public static SimpleDateFormat dateTimeFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");

    public static LocalDate dateToLocalDate(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId  = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    public static Date localToDate(LocalDate localDate){
        ZoneId zoneId = ZoneId.systemDefault();
        ChronoZonedDateTime<LocalDate> zonedDateTime = localDate.atStartOfDay(zoneId);
        return Date.from(zonedDateTime.toInstant());
    }
    public static String getDateString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(date);
    }

    /**
     * 计算今天还剩多少秒
     */
    public static int  remainingTime(){
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        final double seconds = (cal.getTimeInMillis() - System.currentTimeMillis())/1000;
        return (int) seconds;
    }

    public static String standardTimeToStringDateTime(Date date){
        return dateTimeFormat.format(date);
    }

    public static String standardTimeToStringDate(Date date){
        return dateFormat.format(date);
    }

    public static Date stringTimeToStandardTime(String time) {
        try {
            return dateTimeFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) throws ParseException {

        System.out.println(System.currentTimeMillis());
//        System.out.println(stringTimeToStandardTime(standardTimeToStringTime(new Date())).getTime());
//        System.out.println(standardTimeToStringTime(new Date()));
    }

}
