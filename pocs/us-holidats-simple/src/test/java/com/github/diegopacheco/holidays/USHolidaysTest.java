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
    public void tenDecadesNewYearEveHoliday(){
        for (int i=1;i<=100;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.JANUARY, 1).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

    @Test
    public void tenDecadesIndependenceDayHoliday(){
        for (int i=1;i<=100;i++){
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
        List<Date> birthdayMLKHolidays = new ArrayList<>();
        birthdayMLKHolidays.add(new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2025, Calendar.JANUARY, 20).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2026, Calendar.JANUARY, 19).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2027, Calendar.JANUARY, 18).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2028, Calendar.JANUARY, 17).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2029, Calendar.JANUARY, 15).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2030, Calendar.JANUARY, 21).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2031, Calendar.JANUARY, 20).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2032, Calendar.JANUARY, 19).getTime());
        birthdayMLKHolidays.add(new GregorianCalendar(2033, Calendar.JANUARY, 17).getTime());

        for(Date d: birthdayMLKHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void birthdayWashington10Years(){
        List<Date> birthdayWashingtonHolidays = new ArrayList<>();
        birthdayWashingtonHolidays.add(new GregorianCalendar(2019, Calendar.FEBRUARY, 18).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2020, Calendar.FEBRUARY, 17).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2021, Calendar.FEBRUARY, 15).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2022, Calendar.FEBRUARY, 21).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2023, Calendar.FEBRUARY, 20).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2024, Calendar.FEBRUARY, 19).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2025, Calendar.FEBRUARY, 17).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2026, Calendar.FEBRUARY, 16).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2027, Calendar.FEBRUARY, 15).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2028, Calendar.FEBRUARY, 21).getTime());
        birthdayWashingtonHolidays.add(new GregorianCalendar(2029, Calendar.FEBRUARY, 19).getTime());

        for(Date d: birthdayWashingtonHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void memorialDayTenYears(){
        List<Date> memorialDayHolidays = new ArrayList<>();
        memorialDayHolidays.add(new GregorianCalendar(2017, Calendar.MAY, 29).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2018, Calendar.MAY, 28).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2019, Calendar.MAY, 27).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2020, Calendar.MAY, 25).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2021, Calendar.MAY, 31).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2022, Calendar.MAY, 30).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2023, Calendar.MAY, 29).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2024, Calendar.MAY, 27).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2025, Calendar.MAY, 26).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2026, Calendar.MAY, 25).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2027, Calendar.MAY, 31).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2028, Calendar.MAY, 29).getTime());
        memorialDayHolidays.add(new GregorianCalendar(2029, Calendar.MAY, 28).getTime());

        for(Date d: memorialDayHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void laborDayYears(){
        List<Date> laborDayHolidays = new ArrayList<>();
        laborDayHolidays.add(new GregorianCalendar(2024, Calendar.SEPTEMBER, 2).getTime());
        laborDayHolidays.add(new GregorianCalendar(2025, Calendar.SEPTEMBER, 1).getTime());
        laborDayHolidays.add(new GregorianCalendar(2026, Calendar.SEPTEMBER, 7).getTime());
        laborDayHolidays.add(new GregorianCalendar(2027, Calendar.SEPTEMBER, 6).getTime());
        laborDayHolidays.add(new GregorianCalendar(2028, Calendar.SEPTEMBER, 4).getTime());
        laborDayHolidays.add(new GregorianCalendar(2029, Calendar.SEPTEMBER, 3).getTime());
        laborDayHolidays.add(new GregorianCalendar(2030, Calendar.SEPTEMBER, 2).getTime());
        laborDayHolidays.add(new GregorianCalendar(2031, Calendar.SEPTEMBER, 1).getTime());
        laborDayHolidays.add(new GregorianCalendar(2032, Calendar.SEPTEMBER, 6).getTime());
        laborDayHolidays.add(new GregorianCalendar(2033, Calendar.SEPTEMBER, 5).getTime());

        for(Date d: laborDayHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void columbusDayFor10Years(){
        List<Date> columbusHolidays = new ArrayList<>();
        columbusHolidays.add(new GregorianCalendar(2018, Calendar.OCTOBER, 8).getTime());
        columbusHolidays.add(new GregorianCalendar(2019, Calendar.OCTOBER, 14).getTime());
        columbusHolidays.add(new GregorianCalendar(2020, Calendar.OCTOBER, 12).getTime());
        columbusHolidays.add(new GregorianCalendar(2021, Calendar.OCTOBER, 11).getTime());
        columbusHolidays.add(new GregorianCalendar(2022, Calendar.OCTOBER, 10).getTime());
        columbusHolidays.add(new GregorianCalendar(2023, Calendar.OCTOBER, 9).getTime());
        columbusHolidays.add(new GregorianCalendar(2024, Calendar.OCTOBER, 14).getTime());
        columbusHolidays.add(new GregorianCalendar(2025, Calendar.OCTOBER, 13).getTime());
        columbusHolidays.add(new GregorianCalendar(2026, Calendar.OCTOBER, 12).getTime());
        columbusHolidays.add(new GregorianCalendar(2027, Calendar.OCTOBER, 11).getTime());
        columbusHolidays.add(new GregorianCalendar(2028, Calendar.OCTOBER, 9).getTime());

        for(Date d: columbusHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void thanksgivingDayFor10Years(){
        List<Date> thanksgivingHolidays = new ArrayList<>();
        thanksgivingHolidays.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 22).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2019, Calendar.NOVEMBER, 28).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2020, Calendar.NOVEMBER, 26).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2021, Calendar.NOVEMBER, 25).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2022, Calendar.NOVEMBER, 24).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2023, Calendar.NOVEMBER, 23).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2024, Calendar.NOVEMBER, 28).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2025, Calendar.NOVEMBER, 27).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2026, Calendar.NOVEMBER, 26).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2027, Calendar.NOVEMBER, 25).getTime());
        thanksgivingHolidays.add(new GregorianCalendar(2028, Calendar.NOVEMBER, 23).getTime());

        for(Date d: thanksgivingHolidays){
            boolean result = USHolidays.isHoliday(d);
            assertTrue(result);
        }
    }

    @Test
    public void tenDecatesJuneteenthHoliday(){
        for (int i=1;i<=100;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.JUNE, 19).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

    @Test
    public void twoDecatesVeteransHoliday(){
        for (int i=1;i<=20;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.NOVEMBER, 11).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

    @Test
    public void twoDecatesXmasDayHoliday(){
        for (int i=1;i<=20;i++){
            Date holiday = new GregorianCalendar(2019+i, Calendar.DECEMBER, 25).getTime();
            boolean result = USHolidays.isHoliday(holiday);
            assertTrue(result);
        }
    }

}
