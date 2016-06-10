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
import java.util.Date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.just10.coppa.CalendarUtils.fromString;
import static com.just10.coppa.CalendarUtils.getAge;

/**
 * COPPA age check methods
 * @author Mahram Z. Foadi
 */
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class COPPA {
    private static final int MINIMUM_AGE = 14;
    private static final String DATE_STRING_FORMAT = "yyyymmdd";

    /**
     * Is a user with the provided birthday old enough to meet COPPA requirements?
     * @param birthdate the user's birth date as a {@link Calendar} instance.
     * @return <code>true</code> if the user is old enough and <code>false</code> otherwise.
     */
    public static boolean ageMeetsCOPPARequirements (final Calendar birthdate) {
        if (null == birthdate)
            throw new NullPointerException ("birthdate");

        return getAge (birthdate) >= MINIMUM_AGE;
    }

    /**
     * Is a user with the provided birthday old enough to meet COPPA requirements?
     * @param birthdate the user's birth date as milliseconds since midnight January 1, 1970 UTC
     *                  (e.g. from ${@link System#currentTimeMillis()}
     * @return <code>true</code> if the user is old enough and <code>false</code> otherwise.
     */
    public static boolean ageMeetsCOPPARequirements (final long birthdate) {
        Calendar bd = Calendar.getInstance ();
        bd.setTimeInMillis (birthdate);
        return ageMeetsCOPPARequirements (bd);
    }

    /**
     * Is a user with the provided birthday old enough to meet COPPA requirements?
     * @param yyyymmdd the user's birth date as a date string in yyyymmdd format (e.g. 19990912 for September 12, 1999)
     * @return <code>true</code> if the user is old enough and <code>false</code> otherwise.
     */
    public static boolean ageMeetsCOPPARequirements (final String yyyymmdd) {
        if (yyyymmdd == null) throw new NullPointerException ("yyyymmdd");

        if (yyyymmdd.length () != DATE_STRING_FORMAT.length ())
            throw new IllegalArgumentException ("Invalid date argument: " + yyyymmdd);

        return ageMeetsCOPPARequirements (fromString (yyyymmdd));
    }
}
