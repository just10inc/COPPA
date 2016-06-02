/*
 * TimeUtilsTests.cpp
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#include "TimeUtilsTests.h"
#include <time_utils.h>
#include <qtest.h>

using namespace just10::coppa::util;

const char * TimeUtilsTests::Name()
{
    return "TimeUtils Tests";
}

void assertDateMatches (const QDate& actual, const int year, const int month, const int day) {
    QVERIFY(year == actual.year());
    QVERIFY(month == actual.month());
    QVERIFY(day == actual.day());
}

void TimeUtilsTests::testQDateFromString()
{
    assertDateMatches (fromYYYYMMDD("19790922"), 1979, 9, 22);
    assertDateMatches (fromYYYYMMDD("20160602"), 2016, 6, 2);
    assertDateMatches (fromYYYYMMDD("22001125"), 2200, 11, 25);
}

void TimeUtilsTests::testQDateFromEmptyStringThrows()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromNonDigitStringThrows()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromNonDigitYearStringThrows()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromNonDigitMonthStringThrows()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromNonDigitDayStringThrows()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromTooShortString()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testQDateFromTooLongString()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testBornTodayIsZeroAged()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testBornNowIsZeroAged()
{
    QFAIL("Not implemented");
}

void TimeUtilsTests::testAgesByAddedDates()
{
    QFAIL("Not implemented");
}
