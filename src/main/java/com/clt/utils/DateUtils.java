package com.clt.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;

/**
 * @author ：clt
 * @Date ：Created in 18:58 2020/02/25
 */
public class DateUtils {
    private DateUtils(){}

    public static final String DAY = "DAY";

    public static final String MONTH = "MONTH";

    public static final String YEAR = "YEAR";

    public static final long oneDay = 86400000;

    public static long daysToTimestamp(long days){
        return days * 24 * 3600 * 1000;
    }

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


    public static void main(String[] args) {
        System.out.println(getDateString(new Date()));
    }

}
