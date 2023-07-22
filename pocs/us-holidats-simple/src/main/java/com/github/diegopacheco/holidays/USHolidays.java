package com.github.diegopacheco.holidays;

import com.github.diegopacheco.holidays.checkers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class USHolidays {

    private static final List<Holiday> holidays = new ArrayList<>();

    static{
        holidays.add(new NewYearEveHoliday());
        holidays.add(new BirthdayMLK());
        holidays.add(new BirthdayWashington());
        holidays.add(new JuneteenthDay());
        holidays.add(new IndependenceDay());
        holidays.add(new LaborDay());
        holidays.add(new MemorialDay());
        holidays.add(new VeteransDay());
        holidays.add(new XmasHoliday());
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
