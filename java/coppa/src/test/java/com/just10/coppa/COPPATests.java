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

import static com.just10.coppa.CalendarUtils.now;
import static com.just10.coppa.TestUtils.moveDate;
import static com.just10.coppa.TestUtils.toyyyyMMdd;
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
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (now ())));
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (0, 0, -15))));
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (0, -5, 0))));
    }

    @Test
    public void testOneYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-1, 0, 0))));
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-1, 3, 0))));
    }

    @Test
    public void testFiveYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-5, 0, 0))));
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-5, 6, 4))));
    }

    @Test
    public void testThirteenYearOldStringDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-13, 0, 0))));
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-13, 7, 0))));
    }

    @Test
    public void testFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements ()
    {
        assertFalse (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-14, 0, 1))));
    }

    @Test
    public void testFourteenYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-14, 0, 0))));
    }

    @Test
    public void testFourteenYearOldAndADayStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-14, 0, -1))));
    }

    @Test
    public void testFifteenYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-15, 0, 0))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-15, 0, -20))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-15, -4, -27))));
    }

    @Test
    public void testEighteenYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-18, 0, 0))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-18, 0, -7))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-18, -8, -17))));
    }

    @Test
    public void testTwentyYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-20, 0, 0))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-20, 0, -23))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-20, -2, -19))));
    }

    @Test
    public void testFiftyYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-50, 0, 0))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-50, 0, -13))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-50, -10, 1))));
    }

    @Test
    public void testHundredYearOldStringDateMeetsCOPPARequirements ()
    {
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-100, 0, 0))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-100, 0, -19))));
        assertTrue (ageMeetsCOPPARequirements (toyyyyMMdd (moveDate (-100, -3, 7))));
    }
}