/*
 * COPPATests.cpp
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#include <QTest.h>
#include "COPPATests.h"
#include <coppa.h>
#include <time_utils.h>
#include "TestUtils.h"

using namespace just10::coppa;
using namespace just10::coppa::util;

const char * COPPATests::Name()
{
    return "COPPA Tests";
}

// AgeMeetsCOPPARequirements (QDate birthdate)
void COPPATests::testZeroYearOldDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(today()));
}

void COPPATests::testOneYearOldDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1)));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1, 3)));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1, -2, -12)));
}
void COPPATests::testFiveYearOldDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-5)));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-5, 6, -4)));
}
void COPPATests::testThirteenYearOldDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-13)));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-13, 7)));
}
void COPPATests::testFourteenYearOldDayShortDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-14, 0, 1)));
}
void COPPATests::testFourteenYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14, -3, 1)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, 0, 1)));
}
void COPPATests::testFourteenYearOldAndADayDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14, 0, -1)));
}
void COPPATests::testFifteenYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, 0, -17)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, -5, -27)));
}
void COPPATests::testEighteenYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18, 0, -7)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18, -8, -13)));
}
void COPPATests::testTwentyYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20, 0, -15)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20, -3, -20)));
}
void COPPATests::testFiftyYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50, 0, -7)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50, -10, 3)));
}
void COPPATests::testHundredYearOldDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100, 0, -19)));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100, -4, -14)));
}
// AgeMeetsCOPPARequirements (long birthdate)
void COPPATests::testZeroYearOldLongDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime().toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(0, -5).toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(0, 0, -23).toMSecsSinceEpoch()));
}
void COPPATests::testOneYearOldLongDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-1).toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-1, 3).toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-1, -2, -12).toMSecsSinceEpoch()));
}
void COPPATests::testFiveYearOldLongDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-5).toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-5, 6, -4).toMSecsSinceEpoch()));
}
void COPPATests::testThirteenYearOldLongDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-13).toMSecsSinceEpoch()));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-13, 7).toMSecsSinceEpoch()));
}
void COPPATests::testFourteenYearOldDayShortLongDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveTime(-14, 0, 1).toMSecsSinceEpoch()));
}
void COPPATests::testFourteenYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-14).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-14, -3, 1).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-15, 0, 1).toMSecsSinceEpoch()));
}
void COPPATests::testFourteenYearOldAndADayLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-14, 0, -1).toMSecsSinceEpoch()));
}
void COPPATests::testFifteenYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-15).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-15, 0, -17).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-15, -5, -27).toMSecsSinceEpoch()));
}
void COPPATests::testEighteenYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-18).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-18, 0, -7).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-18, -8, -13).toMSecsSinceEpoch()));
}
void COPPATests::testTwentyYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-20).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-20, 0, -15).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-20, -3, -20).toMSecsSinceEpoch()));
}
void COPPATests::testFiftyYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-50).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-50, 0, -7).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-50, -10, 3).toMSecsSinceEpoch()));
}
void COPPATests::testHundredYearOldLongDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-100).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-100, 0, -19).toMSecsSinceEpoch()));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveTime(-100, -4, -14).toMSecsSinceEpoch()));
}
// AgeMeetsCOPPARequirements (QString birthdate)
void COPPATests::testZeroYearOldStringDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(today().toString("yyyyMMdd")));
}
void COPPATests::testOneYearOldStringDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1).toString("yyyyMMdd")));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1, 3).toString("yyyyMMdd")));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-1, -2, -12).toString("yyyyMMdd")));
}
void COPPATests::testFiveYearOldStringDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-5).toString("yyyyMMdd")));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-5, 6, -4).toString("yyyyMMdd")));
}
void COPPATests::testThirteenYearOldStringDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-13).toString("yyyyMMdd")));
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-13, 7).toString("yyyyMMdd")));
}
void COPPATests::testFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements()
{
    ASSERT_FALSE(ageMeetsCOPPARequirements(moveDate(-14, 0, 1).toString("yyyyMMdd")));
}
void COPPATests::testFourteenYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14, -3, 1).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, 0, 1).toString("yyyyMMdd")));
}
void COPPATests::testFourteenYearOldAndADayStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-14, 0, -1).toString("yyyyMMdd")));
}
void COPPATests::testFifteenYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, 0, -17).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-15, -5, -27).toString("yyyyMMdd")));
}
void COPPATests::testEighteenYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18, 0, -7).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-18, -8, -13).toString("yyyyMMdd")));
}
void COPPATests::testTwentyYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20, 0, -15).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-20, -3, -20).toString("yyyyMMdd")));
}
void COPPATests::testFiftyYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50, 0, -7).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-50, -10, 3).toString("yyyyMMdd")));
}
void COPPATests::testHundredYearOldStringDateMeetsCOPPARequirements()
{
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100, 0, -19).toString("yyyyMMdd")));
    ASSERT_TRUE(ageMeetsCOPPARequirements(moveDate(-100, -4, -14).toString("yyyyMMdd")));
}

