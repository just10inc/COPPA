/**
 Copyright 2016 Just10 Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.just10.coppa;

import java.util.Calendar;

/**
 Simple calendar utility methods.
 * @author Mahram Z. Foadi
 */
public class CalendarUtils {

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
     @return current time
     */
    static Calendar now () {
        return Calendar.getInstance ();
    }

    /**
     @return Gets a calendar instance pointing to 00:00:00 of current day
     */
    static Calendar today () {
        return setMidnight (now ());
    }

    static Calendar setMidnight (final Calendar date) {
        date.set (Calendar.HOUR_OF_DAY, 0);
        date.set (Calendar.MINUTE, 0);
        date.set (Calendar.SECOND, 0);
        date.set (Calendar.MILLISECOND, 0);
        return date;
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

        return setMidnight (cal);
    }
}
