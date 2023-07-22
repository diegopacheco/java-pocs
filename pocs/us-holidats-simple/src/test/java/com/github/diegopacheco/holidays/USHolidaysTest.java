package com.github.diegopacheco.holidays;

import org.junit.jupiter.api.Test;

import java.util.*;

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

    @Test
    public void birthdayMLKFor10Years(){
        List<Date> mlkHolidays = new ArrayList<>();
        mlkHolidays.add(new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime());
        mlkHolidays.add(new GregorianCalendar(2025, Calendar.JANUARY, 20).getTime());
        mlkHolidays.add(new GregorianCalendar(2026, Calendar.JANUARY, 19).getTime());
        mlkHolidays.add(new GregorianCalendar(2027, Calendar.JANUARY, 18).getTime());
        mlkHolidays.add(new GregorianCalendar(2028, Calendar.JANUARY, 17).getTime());
        mlkHolidays.add(new GregorianCalendar(2029, Calendar.JANUARY, 15).getTime());
        mlkHolidays.add(new GregorianCalendar(2030, Calendar.JANUARY, 21).getTime());
        mlkHolidays.add(new GregorianCalendar(2031, Calendar.JANUARY, 20).getTime());
        mlkHolidays.add(new GregorianCalendar(2032, Calendar.JANUARY, 19).getTime());
        mlkHolidays.add(new GregorianCalendar(2033, Calendar.JANUARY, 17).getTime());

        for(Date d: mlkHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

}
