package com.github.diegopacheco.holidays;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class USHolidaysTest {

    @Test
    public void notAHoliday(){
        Date notHoliday = new GregorianCalendar(2023, Calendar.JANUARY, 2).getTime();
        boolean result = USHolidays.isHoliday(notHoliday);
        assertFalse(result);
    }

    @Test
    public void tenDecatesNewYearEveHoliday(){
        for (int i=1;i<=20;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.JANUARY, 1).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

    @Test
    public void tenDecatesIndependenceDayHoliday(){
        for (int i=1;i<=20;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.JULY, 4).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

    @Test
    public void birthdayMLK2023(){
        Date notHoliday = new GregorianCalendar(2023, Calendar.JANUARY, 16).getTime();
        boolean result = USHolidays.isHoliday(notHoliday);
        assertTrue(result);
    }

}
