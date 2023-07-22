package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class MemorialDay implements Holiday {
    @Override
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate september = LocalDate.of(localDate.getYear(), Month.MAY, 1);
        LocalDate lastMondayinMay = september.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));

        Instant parameterInstant = date.toInstant();
        Instant holidayInstant = lastMondayinMay.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return holidayInstant.equals(parameterInstant);
    }
}
