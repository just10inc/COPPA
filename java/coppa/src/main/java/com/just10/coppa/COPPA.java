package com.just10.coppa;

import java.util.Calendar;
import java.util.Date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.just10.coppa.CalendarUtils.fromString;
import static com.just10.coppa.CalendarUtils.getAge;

/**
 Created by mahramf on 2016-05-27.
 */
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class COPPA {
    private static final int MINIMUM_AGE = 14;
    private static final String DATE_STRING_FORMAT = "yyyymmdd";

    public static boolean ageMeetsCOPPARequirements (final Calendar birthdate) {
        if (null == birthdate)
            throw new NullPointerException ("birthdate");

        return getAge (birthdate) >= MINIMUM_AGE;
    }

    public static boolean ageMeetsCOPPARequirements (final long birthdate) {
        Calendar bd = Calendar.getInstance ();
        bd.setTimeInMillis (birthdate);
        return ageMeetsCOPPARequirements (bd);
    }

    public static boolean ageMeetsCOPPARequirements (final String yyyymmdd) {
        if (yyyymmdd == null) throw new NullPointerException ("yyyymmdd");

        if (yyyymmdd.length () != DATE_STRING_FORMAT.length ())
            throw new IllegalArgumentException ("Invalid date argument: " + yyyymmdd);

        return ageMeetsCOPPARequirements (fromString (yyyymmdd));
    }
}
