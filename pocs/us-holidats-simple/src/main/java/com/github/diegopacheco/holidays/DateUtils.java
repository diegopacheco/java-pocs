package com.github.diegopacheco.holidays;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    private static final ZoneId zoneId = ZoneId.of("America/Los_Angeles");

    public static LocalDate fromDate(Date date){
        Instant instant = date.toInstant();
        LocalDate currentDate = LocalDate.ofInstant(instant,zoneId);
        return currentDate;
    }

    public static ZoneId getCurrentZoneId(){
        return zoneId;
    }

}
