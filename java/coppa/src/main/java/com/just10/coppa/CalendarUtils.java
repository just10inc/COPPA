package com.just10.coppa;

import java.util.Calendar;

/**
 Created by mahramf on 2016-05-30.
 */
public class CalendarUtils {
    /**
     Calculates the age corresponding to the provided birthdate
     @param birthdate birthdate
     @return calculated age
     */
    public static int getAge (final Calendar birthdate) {
        final Calendar today = today ();

        final int birthYear = birthdate.get (Calendar.YEAR);
        final int birthMonth = birthdate.get (Calendar.MONTH);
        final int birthDay = birthdate.get (Calendar.DAY_OF_MONTH);
        
        final int thisYear = today.get (Calendar.YEAR);
        final int thisMonth = today.get (Calendar.MONTH);       
        final int thisDay = today.get (Calendar.DAY_OF_MONTH);

        final boolean notReachedBDThisYear = (birthMonth > thisMonth || (birthMonth == thisMonth && birthDay > thisDay));
        return thisYear - birthYear - (notReachedBDThisYear ? 1 : 0);
    }

    /**
     Converts a yyyyMMdd string to a calendar instance
     @param yyyymmdd date string in yyyyMMdd format
     @return the corresponding Calendar instance
     @throws NumberFormatException if the string contains non numerics
     */
    public static Calendar fromString (final String yyyymmdd) throws NumberFormatException, NullPointerException {
        if (null == yyyymmdd) throw new NullPointerException ("date string");

        if (yyyymmdd.length () != "yyyyMMdd".length ())
            throw new IllegalArgumentException ("Incorrect string length. Please provide data as yyyyMMdd.");

        return byDate (Integer.parseInt (yyyymmdd.substring (0, 4)),
                       Integer.parseInt (yyyymmdd.substring (4, 6)),
                       Integer.parseInt (yyyymmdd.substring (6, 8)));
    }

    /**
     Gets the current time
     @return
     */
    static Calendar now () {
        return Calendar.getInstance ();
    }

    /**
     @return Gets a calendar instance pointing to 00:00:00 of current day
     */
    static Calendar today () {
        final Calendar today = now ();
        today.set (Calendar.HOUR, 0);
        today.set (Calendar.MINUTE, 0);
        today.set (Calendar.SECOND, 0);
        today.set (Calendar.MILLISECOND, 0);

        return today;
    }

    /**
     Construct a calendar object given year, month, and day
     @param year year
     @param month month
     @param day day of month
     @return Corresponding calendar instance
     */
    static Calendar byDate (final int year, final int month, final int day) {
        Calendar cal = Calendar.getInstance ();
        cal.setTimeInMillis (0);

        cal.set (Calendar.YEAR, year);
        cal.set (Calendar.MONTH, month - 1);
        cal.set (Calendar.DAY_OF_MONTH, day);

        return cal;
    }
}
