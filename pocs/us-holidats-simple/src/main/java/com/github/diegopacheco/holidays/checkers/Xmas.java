package com.github.diegopacheco.holidays.checkers;

import com.github.diegopacheco.holidays.DateUtils;
import com.github.diegopacheco.holidays.Holiday;

import java.time.LocalDate;
import java.util.Date;

public class Xmas implements Holiday {

    @Override
    public boolean isHoliday(Date date) {
        if (null==date){
            return false;
        }
        LocalDate localDate = DateUtils.fromDate(date);
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonth().getValue();
        if (25==day && 12==month){
            return true;
        }
        return false;
    }
}