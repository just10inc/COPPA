package com.just10.coppa;

import java.util.Calendar;
import java.util.Date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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

    public static int getAge(final Calendar birthdate, final Calendar today) {
        final int birthYear = birthdate.get (Calendar.YEAR);
        final int refYear = today.get(Calendar.YEAR);
        final int birthMonth = birthdate.get(Calendar.MONTH);
        final int refMonth = today.get (Calendar.MONTH);
        final int birthDay = birthdate.get(Calendar.DAY_OF_MONTH);
        final int refDay = today.get(Calendar.DAY_OF_MONTH);

        final boolean notReachedBDThisYear = (birthMonth > refMonth || (birthMonth == refMonth && birthDay > refDay));
        return refYear - birthYear - (notReachedBDThisYear ? 1 : 0);
    }

    public static int getAge(final Calendar birthdate) {
        return getAge (birthdate, Calendar.getInstance ());
    }

    public static Calendar fromString (final String yyyymmdd) throws NumberFormatException {
        Calendar bd = Calendar.getInstance ();
        bd.setTimeInMillis (0);
        bd.set (Calendar.YEAR, Integer.parseInt (yyyymmdd.substring (0, 4)));
        bd.set (Calendar.MONTH, Integer.parseInt (yyyymmdd.substring (4, 2)));
        bd.set (Calendar.DAY_OF_MONTH, Integer.parseInt (yyyymmdd.substring (6, 2)));

        return bd;
    }
}
