package com.github.diegopacheco.holidays;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

    private static final ZoneId zoneId = ZoneId.of("America/Los_Angeles");

    public static LocalDate nthWeek(Date date, int month,DayOfWeek dayOfWeek){
        Instant instant = date.toInstant();
        LocalDate currentDate = LocalDate.ofInstant(instant,zoneId);
        LocalDate nth = currentDate.with(TemporalAdjusters.dayOfWeekInMonth(month, dayOfWeek));
        return nth;
    }

    public static LocalDate lastMondayOfMonth(Date date){
        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
        LocalDate lastMonday = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        return lastMonday;
    }

    public static LocalDate secondMondayOfMonth(Date date){
        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
        LocalDate lastMonday = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        return lastMonday;
    }

    public static LocalDate lastThursdayOfMonth(Date date){
        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
        LocalDate lastMonday = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
        return lastMonday;
    }


    public static LocalDate fromDate(Date date){
        Instant instant = date.toInstant();
        LocalDate currentDate = LocalDate.ofInstant(instant,zoneId);
        return currentDate;
    }

    public static ZoneId getCurrentZoneId(){
        return zoneId;
    }

}
