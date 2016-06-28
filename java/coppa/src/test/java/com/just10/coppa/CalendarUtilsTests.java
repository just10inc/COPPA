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

import org.junit.Test;

import java.util.Calendar;

import static com.just10.coppa.CalendarUtils.fromString;
import static com.just10.coppa.CalendarUtils.now;
import static com.just10.coppa.CalendarUtils.today;
import static org.junit.Assert.*;

/**
 To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalendarUtilsTests {
    @Test
    public void testNowIsToday () {
        AssertDatesEqualEnough (today (), now(), Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
    }

    @Test
    public void byDateCreatesCorrectDate () {
        Calendar date = CalendarUtils.byDate (1979, 9, 22);
        assertEquals (1979, date.get(Calendar.YEAR));
        assertEquals (Calendar.SEPTEMBER, date.get(Calendar.MONTH));
        assertEquals (22, date.get(Calendar.DAY_OF_MONTH));

        date = CalendarUtils.byDate (1970, 1, 1);
        assertEquals (1970, date.get(Calendar.YEAR));
        assertEquals (Calendar.JANUARY, date.get(Calendar.MONTH));
        assertEquals (1, date.get(Calendar.DAY_OF_MONTH));

        date = CalendarUtils.byDate (2179, 8, 12);
        assertEquals (2179, date.get(Calendar.YEAR));
        assertEquals (Calendar.AUGUST, date.get(Calendar.MONTH));
        assertEquals (12, date.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testFromString ()
    {
        assertDate (1979, Calendar.SEPTEMBER, 22, fromString ("19790922"));
        assertDate (2016, Calendar.MAY, 30, fromString ("20160530"));
    }

    @Test (expected = NullPointerException.class)
    public void testNullFromStringThrows ()
    {
        fromString (null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMissingYearFromStringThrows ()
    {
        fromString ("0922");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShortLengthFromStringThrows ()
    {
        fromString ("440922");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLongLengthFromStringThrows ()
    {
        fromString ("3332234440922");
    }

    @Test (expected = NumberFormatException.class)
    public void testNonNumbericFromStringThrows ()
    {
        fromString ("9x87654c");
    }

    @Test (expected = NumberFormatException.class)
    public void testNonNumbericYearFromStringThrows ()
    {
        fromString ("yyyy0523");
    }

    @Test (expected = NumberFormatException.class)
    public void testNonNumbericMonthFromStringThrows ()
    {
        fromString ("2000m923");
    }

    @Test (expected = NumberFormatException.class)
    public void testNonNumbericDayFromStringThrows ()
    {
        fromString ("2000092x");
    }

    private void AssertDatesEqualEnough (final Calendar expected, final Calendar actual)
    {
        AssertDatesEqualEnough (expected, actual,
                                Calendar.YEAR,
                                Calendar.MONTH,
                                Calendar.DAY_OF_MONTH,
                                Calendar.HOUR,
                                Calendar.MINUTE,
                                Calendar.SECOND,
                                Calendar.MILLISECOND
                                );
    }

    private void AssertDatesEqualEnough (final Calendar expected, final Calendar actual, final int... fields)
    {
        if (null == fields || fields.length == 0)
            fail ("No fields specified");

        for (final int field : fields)
            assertEquals (expected.get (field), actual.get (field));
    }

    private void assertDate (final int year, final int month, final int day, final Calendar actual) {
        assertEquals (year, actual.get (Calendar.YEAR));
        assertEquals (month, actual.get (Calendar.MONTH));
        assertEquals (day, actual.get (Calendar.DAY_OF_MONTH));
    }
}