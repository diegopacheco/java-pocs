package com.github.diegopacheco.holidays;

import com.github.diegopacheco.holidays.checkers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class USHolidays implements Holiday{

    private static final List<Holiday> holidays = new ArrayList<>();

    static{
        holidays.add(new NewYearEve());
        holidays.add(new BirthdayMLK());
        holidays.add(new BirthdayWashington());
        holidays.add(new JuneteenthDay());
        holidays.add(new IndependenceDay());
        holidays.add(new LaborDay());
        holidays.add(new ColumbusDay());
        holidays.add(new MemorialDay());
        holidays.add(new VeteransDay());
        holidays.add(new Thanksgiving());
        holidays.add(new Xmas());
    }

    public boolean isHoliday(Date date){
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
