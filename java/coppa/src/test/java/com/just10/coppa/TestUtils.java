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

import java.text.SimpleDateFormat;
import java.util.Calendar;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.just10.coppa.CalendarUtils.now;

/**
 Created by mahramf on 2016-05-31.
 */
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class TestUtils {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat ("yyyyMMdd");

    /**
     @param cal

     @return
     */
    static String toyyyyMMdd (final Calendar cal) {
        return FORMATTER.format (cal.getTime ());
    }

    /**
     Moves the given date by the given year, month, and day values. Positive values move towards the future and
     negative values move towards the past.
     @param cal {@link Calendar} instance to update
     @param years number of years by which to move the date.
     @param months number of months by which to move the date.
     @param days number of days by which to move the date.
     */
    static Calendar moveDate (final Calendar cal, int years, int months, int days) {
        if (years != 0)
            cal.add (Calendar.YEAR, years);

        if (months != 0)
            cal.add (Calendar.MONTH, months);

        if (days != 0)
            cal.add (Calendar.DAY_OF_YEAR, days);

        return cal;
    }

    /**
     Moves today's date by the given year, month, and day values.
     @param years
     @param months
     @param days
     @return
     */
    static Calendar moveDate (int years, int months, int days) {
        return moveDate (now (), years, months, days);
    }
}
