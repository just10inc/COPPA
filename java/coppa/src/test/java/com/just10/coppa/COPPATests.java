package com.just10.coppa;

import org.junit.Test;

import java.util.Calendar;

import static com.just10.coppa.CalendarUtils.moveDate;
import static org.junit.Assert.*;
import static com.just10.coppa.COPPA.ageMeetsCOPPARequirements;

/**
 To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class COPPATests {
    @Test
    public void testZeroYearOldDateTimeDoesntMeetsCOPPARequirements()
    {
        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.now ()));
        Calendar bd = CalendarUtils.now ();
        bd.add (Calendar.DAY_OF_YEAR, -15);
        assertFalse (ageMeetsCOPPARequirements (bd));

        bd = CalendarUtils.now ();
        bd.add (Calendar.MONTH, -5);
        assertFalse (ageMeetsCOPPARequirements (bd));
    }

    @Test
    public void testOneYearOldDateTimeDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate(-1,0,0)));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-1, 3, 0)));
    }

    @Test
    public void testFiveYearOldDateTimeDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-5, 0, 0)));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-5, 6, 4)));
    }

    @Test
    public void testThirteenYearOldDateTimeDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-13, 0, 0)));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-13, 7, 0)));
    }

    @Test
    public void testFourteenYearOldDayShortDateTimeDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-14, 0, 1)));
    }

    @Test
    public void testFourteenYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-14, 0, 0)));
    }

    @Test
    public void testFourteenYearOldAndADayDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-14, 0, -1)));
    }

    @Test
    public void testFifteenYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, 0, 0)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, 0, -20)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, -4, -26)));
    }

    @Test
    public void testEighteenYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, 0, 0)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, 0, -7)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, -8, -12)));
    }

    @Test
    public void testTwentyYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, 0, 0)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, 0, -22)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, -2, -15)));
    }

    @Test
    public void testFiftyYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, 0, 0)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, 0, -9)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, -10, 1)));
    }

    @Test
    public void testHundredYearOldDateTimeMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, 0, 0)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, 0, -19)));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, -3, -21)));
    }

    // ageMeetsCOPPARequirements (long birthdate)
    @Test
    public void testZeroYearOldLongDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (0, 0, 0).getTimeInMillis ()));
        assertFalse (ageMeetsCOPPARequirements (moveDate (0, 0, -15).getTimeInMillis ()));
        assertFalse (ageMeetsCOPPARequirements (moveDate (0, -5, 0).getTimeInMillis ()));
    }

    @Test
    public void testOneYearOldLongDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-1, 0, 0).getTimeInMillis ()));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-1, 3, 0).getTimeInMillis ()));
    }

    @Test
    public void testFiveYearOldLongDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-5, 0, 0).getTimeInMillis ()));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-5, 6, 4).getTimeInMillis ()));
    }

    @Test
    public void testThirteenYearOldLongDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-13, 0, 0).getTimeInMillis ()));
        assertFalse (ageMeetsCOPPARequirements (moveDate (-13, 7, 0).getTimeInMillis ()));
    }

    @Test
    public void testFourteenYearOldDayShortLongDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (moveDate (-14, 1, 0).getTimeInMillis ()));
    }

    @Test
    public void testFourteenYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-14, 0, 0).getTimeInMillis ()));
    }

    @Test
    public void testFourteenYearOldAndADayLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-14, -1, 0).getTimeInMillis ()));
    }

    @Test
    public void testFifteenYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, 0, 0).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, 0, -20).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-15, -4, -12).getTimeInMillis ()));
    }

    @Test
    public void testEighteenYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, 0, 0).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, 0, -7).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-18, -8, -12).getTimeInMillis ()));
    }

    @Test
    public void testTwentyYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, 0, 0).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, 0, -25).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-20, -2, -15).getTimeInMillis ()));
    }

    @Test
    public void testFiftyYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, 0, 0).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, 0, -9).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-50, -10, 1).getTimeInMillis ()));
    }

    @Test
    public void testHundredYearOldLongDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, 0, 0).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, 0, -19).getTimeInMillis ()));
        assertTrue (ageMeetsCOPPARequirements (moveDate (-100, -3, -21).getTimeInMillis ()));
    }

    // ageMeetsCOPPARequirements (string yyyymmdd)
    @Test
    public void testZeroYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        //assertFalse (ageMeetsCOPPARequirements ());
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.now ().AsYYYYMMDD ()));
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddDays (-15).AsYYYYMMDD ()));
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.now ().AddMonths (-5).AsYYYYMMDD ()));
    }

    @Test
    public void testOneYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-1).AsYYYYMMDD ()));
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-1).AddMonths (3).AsYYYYMMDD
//                                                                                                           ()));
    }

    @Test
    public void testFiveYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-5).AsYYYYMMDD ()));
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-5)
//                                                                   .AddMonths (6)
//                                                                   .AddDays (4)
//                                                                   .AsYYYYMMDD ()));
    }

    @Test
    public void testThirteenYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-13).AsYYYYMMDD ()));
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ()
//                                                                   .AddYears (-13)
//                                                                   .AddMonths (7)
//                                                                   .AsYYYYMMDD ()));
    }

    @Test
    public void testFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertFalse (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-14).AddDays (1).AsYYYYMMDD ()));
    }

    @Test
    public void testFourteenYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-14).AsYYYYMMDD ()));
    }

    @Test
    public void testFourteenYearOldAndADayStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-14).AddDays (-1).AsYYYYMMDD ()));
    }

    @Test
    public void testFifteenYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-15).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-15).AddDays (-20).AsYYYYMMDD
//                                                                                                           ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-15)
//                                                                  .AddMonths (-4)
//                                                                  .AddDays (-20)
//                                                                  .AsYYYYMMDD ()));
    }

    @Test
    public void testEighteenYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-18).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-18).AddDays (-7).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-18)
//                                                                  .AddMonths (-8)
//                                                                  .AddDays (-12)
//                                                                  .AsYYYYMMDD ()));
    }

    @Test
    public void testTwentyYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-20).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-20).AddDays (-22).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-20)
//                                                                  .AddMonths (-2)
//                                                                  .AddDays (-15)
//                                                                  .AsYYYYMMDD ()));
    }

    @Test
    public void testFiftyYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-50).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-50).AddDays (-9).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-50)
//                                                                  .AddMonths (-10)
//                                                                  .AddDays (1)
//                                                                  .AsYYYYMMDD ()));
    }

    @Test
    public void testHundredYearOldStringDateMeetsCOPPARequirements ()
    {
        fail ("Not implemented");
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-100).AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ()
//                                                                  .AddYears (-100)
//                                                                  .AddDays (-19)
//                                                                  .AsYYYYMMDD ()));
//        assertTrue (ageMeetsCOPPARequirements (CalendarUtils.today ().AddYears (-100)
//                                                                  .AddMonths (-3)
//                                                                  .AddDays (-21)
//                                                                  .AsYYYYMMDD ()));
    }
}