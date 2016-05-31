package com.just10.coppa;

import org.junit.Test;

import java.util.Calendar;

import static com.just10.coppa.CalendarUtils.fromString;
import static com.just10.coppa.CalendarUtils.moveDate;
import static com.just10.coppa.CalendarUtils.now;
import static com.just10.coppa.CalendarUtils.today;
import static com.just10.coppa.CalendarUtils.getAge;
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
    public void testTodayZeroAge ()
    {
        assertEquals (0, getAge (CalendarUtils.today ()));
        assertEquals (0, getAge (CalendarUtils.now()));
    }

    @Test
    public void testAgesByAddDates ()
    {
        Calendar date = moveDate (0, -3, 1);
        assertEquals (0, getAge (date));

        date = moveDate (0, 0, 0);
        assertEquals (0, getAge (date));

        date = moveDate (0, 0, -10);
        assertEquals (0, getAge (date));

        date = moveDate (0, 0, 10);
        assertEquals (-1, getAge (date));

        date = moveDate (-1, 0, 0);
        assertEquals (1, getAge (date));

        date = moveDate (-5, 0, 1);
        assertEquals (4, getAge (date));

        date = moveDate (-5, 0, 0);
        assertEquals (5, getAge (date));

        date = moveDate (-5, -2, 0);
        assertEquals (5, getAge (date));

        date = moveDate (-12, -6, -10);
        assertEquals (12, getAge (date));

        date = moveDate (-12, -6, 10);
        assertEquals (12, getAge (date));

        date = moveDate (-14, 0, 1);
        assertEquals (13, getAge (date));

        date = moveDate (-14, 0, 0);
        assertEquals (14, getAge (date));

        date = moveDate (-200, 0, -20);
        assertEquals (200, getAge (date));
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