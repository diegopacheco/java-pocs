package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Thanksgiving implements Holiday {
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate november = LocalDate.of(localDate.getYear(), Month.NOVEMBER, 1);
        LocalDate fourthThursdayInNov = november.with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY))
                                                 .with(TemporalAdjusters.next(DayOfWeek.THURSDAY))
                                                 .with(TemporalAdjusters.next(DayOfWeek.THURSDAY))
                                                 .with(TemporalAdjusters.next(DayOfWeek.THURSDAY));

        Instant parameterInstant = date.toInstant();
        Instant holidayInstant = fourthThursdayInNov.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return holidayInstant.equals(parameterInstant);
    }
}
