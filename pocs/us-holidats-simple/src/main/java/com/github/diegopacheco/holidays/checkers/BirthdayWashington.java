package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class BirthdayWashington implements Holiday {
    @Override
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate september = LocalDate.of(localDate.getYear(), Month.FEBRUARY, 1);
        LocalDate thridMondayInFeb = september.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)).
                with(TemporalAdjusters.next(DayOfWeek.MONDAY)).
                with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        Instant parameterInstant = date.toInstant();
        Instant holidayInstant = thridMondayInFeb.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return holidayInstant.equals(parameterInstant);
    }

}
