package com.github.diegopacheco.holidays;

import java.time.*;
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

    public static LocalDate fromDate(Date date){
        Instant instant = date.toInstant();
        LocalDate currentDate = LocalDate.ofInstant(instant,zoneId);
        return currentDate;
    }

    public static ZoneId getCurrentZoneId(){
        return zoneId;
    }

    public static Date today(){
        return new Date();
    }

}
