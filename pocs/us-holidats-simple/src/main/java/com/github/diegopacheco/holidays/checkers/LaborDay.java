package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class LaborDay implements Holiday {
    @Override
    public boolean isHoliday(Date date) {
        if (null == date) {
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        LocalDate lastMondayOfMonth = DateUtils.firstMondayOfMonth(date);

        Instant parameterInstant = date.toInstant();
        Instant nthInstant = lastMondayOfMonth.atStartOfDay(DateUtils.getCurrentZoneId()).toInstant();
        return nthInstant.equals(parameterInstant);
    }
}