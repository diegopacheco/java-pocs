package com.github.diegopacheco.holidays;

import com.github.diegopacheco.holidays.checkers.BirthdayMLK;
import com.github.diegopacheco.holidays.checkers.IndependenceDay;
import com.github.diegopacheco.holidays.checkers.NewYearEveHoliday;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class USHolidays {

    private static final List<Holiday> holidays = new ArrayList<>();

    static{
        holidays.add(new NewYearEveHoliday());
        holidays.add(new IndependenceDay());
        holidays.add(new BirthdayMLK());
    }

    public static boolean isHoliday(Date date){
        if (null==date){
            return false;
        }
        for (Holiday checker : holidays){
            boolean result = checker.isHoliday(date);
            if (true==result){
                return true;
            }
        }
        return false;
    }
}
