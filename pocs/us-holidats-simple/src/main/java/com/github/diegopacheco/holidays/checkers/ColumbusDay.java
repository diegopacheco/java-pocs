package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class ColumbusDay implements Holiday {
    @Override
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate october = LocalDate.of(localDate.getYear(), Month.OCTOBER, 1);
        LocalDate secondMondayInOctober = october.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY))
                                                 .with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));

        Instant parameterInstant = date.toInstant();
        Instant holidayInstant = secondMondayInOctober.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return holidayInstant.equals(parameterInstant);
    }
}
