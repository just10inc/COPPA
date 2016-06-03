/*
 * TimeUtilsTests.cpp
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#include "TimeUtilsTests.h"
#include <time_utils.h>
#include <qtest.h>
#include "TestUtils.h"

using namespace just10::coppa::util;

const char * TimeUtilsTests::Name()
{
    return "TimeUtils Tests";
}

void assertDateMatches (const QDate& actual, const int year, const int month, const int day) {
    QVERIFY(actual.isValid());
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
    EXPECT_THROW(fromYYYYMMDD(""), const char*);
}

void TimeUtilsTests::testQDateFromNonDigitStringThrows()
{
    EXPECT_THROW(fromYYYYMMDD("yyyyMMdd"), const char*);
}

void TimeUtilsTests::testQDateFromNonDigitYearStringThrows()
{
    EXPECT_THROW(fromYYYYMMDD("yyyy0730"), const char*);
}

void TimeUtilsTests::testQDateFromNonDigitMonthStringThrows()
{
    EXPECT_THROW(fromYYYYMMDD("2016x730"), const char*);
}

void TimeUtilsTests::testQDateFromNonDigitDayStringThrows()
{
    EXPECT_THROW(fromYYYYMMDD("201607O4"), const char*);
}

void TimeUtilsTests::testQDateFromTooShortString()
{
    EXPECT_THROW(fromYYYYMMDD("201607"), const char*);
    EXPECT_THROW(fromYYYYMMDD("2016070"), const char*);
    EXPECT_THROW(fromYYYYMMDD("20"), const char*);
}

void TimeUtilsTests::testQDateFromTooLongString()
{
    EXPECT_THROW(fromYYYYMMDD("20160700"), const char*);
    EXPECT_THROW(fromYYYYMMDD("201650700"), const char*);
}

void TimeUtilsTests::testInvalidQDateFromStringThrows () {
    EXPECT_THROW(fromYYYYMMDD("20161899"), const char*);
}

void TimeUtilsTests::testBornTodayIsZeroAged()
{
    QVERIFY(0 == getAge((const QDate)today()));
}

void TimeUtilsTests::testBornNowIsZeroAged()
{
    QVERIFY(0 == getAge((const QDate)now().date()));
}

void TimeUtilsTests::testAgesByAddedDates()
{
    QVERIFY(0 == getAge(today()));
    QVERIFY(0 == getAge(moveDate(0, -3, 1)));
    QVERIFY(0 == getAge(moveDate(0, 0, -11)));
    QVERIFY(0 == getAge(moveDate(-1, 0, 1)));
    QVERIFY(-1 == getAge(moveDate(0, 0, 10)));
    QVERIFY(1 == getAge(moveDate(-1, 0, 0)));
    QVERIFY(4 == getAge(moveDate(-5, 0, 1)));
    QVERIFY(5 == getAge(moveDate(-5, 0, 0)));
    QVERIFY(5 == getAge(moveDate(-5, -2, 0)));
    QVERIFY(12 == getAge(moveDate(-12, -6, -10)));
    QVERIFY(12 == getAge(moveDate(-12, -6, 10)));
    QVERIFY(13 == getAge(moveDate(-14, 0, 1)));
    QVERIFY(14 == getAge(moveDate(-14, 0, 0)));
    QVERIFY(200 == getAge(moveDate(-200, 0, -20)));
}
