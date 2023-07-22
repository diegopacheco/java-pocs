package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LaborDay implements Holiday {
    @Override
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate september = LocalDate.of(localDate.getYear(), Month.SEPTEMBER, 1);
        LocalDate firstMondayInSep = september.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        Instant parameterInstant = date.toInstant();
        Instant holidayInstant = firstMondayInSep.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return holidayInstant.equals(parameterInstant);
    }
}