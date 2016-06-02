/*
 * TimeUtilsTests.h
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#ifndef COPPATESTS_H_
#define COPPATESTS_H_

#include "QtestSuite.h"
#include <coppa.h>

class COPPATests: public QTestSuite
{
    Q_OBJECT
private slots:
    // AgeMeetsCOPPARequirements (QDateTime birthdate)
    void testZeroYearOldDateTimeDoesntMeetsCOPPARequirements();
    void testOneYearOldDateTimeDoesntMeetsCOPPARequirements ();
    void testFiveYearOldDateTimeDoesntMeetsCOPPARequirements ();
    void testThirteenYearOldDateTimeDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDayShortDateTimeDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDateTimeMeetsCOPPARequirements ();
    void testFourteenYearOldAndADayDateTimeMeetsCOPPARequirements ();
    void testFifteenYearOldDateTimeMeetsCOPPARequirements ();
    void testEighteenYearOldDateTimeMeetsCOPPARequirements ();
    void testTwentyYearOldDateTimeMeetsCOPPARequirements ();
    void testFiftyYearOldDateTimeMeetsCOPPARequirements ();
    void testHundredYearOldDateTimeMeetsCOPPARequirements ();
    // AgeMeetsCOPPARequirements (QDate birthdate)
    void testZeroYearOldDateDoesntMeetsCOPPARequirements();
    void testOneYearOldDateDoesntMeetsCOPPARequirements ();
    void testFiveYearOldDateDoesntMeetsCOPPARequirements ();
    void testThirteenYearOldDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDayShortDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDateMeetsCOPPARequirements ();
    void testFourteenYearOldAndADayDateMeetsCOPPARequirements ();
    void testFifteenYearOldDateMeetsCOPPARequirements ();
    void testEighteenYearOldDateMeetsCOPPARequirements ();
    void testTwentyYearOldDateMeetsCOPPARequirements ();
    void testFiftyYearOldDateMeetsCOPPARequirements ();
    void testHundredYearOldDateMeetsCOPPARequirements ();
    // AgeMeetsCOPPARequirements (long birthdate)
    void testZeroYearOldLongDateDoesntMeetsCOPPARequirements();
    void testOneYearOldLongDateDoesntMeetsCOPPARequirements ();
    void testFiveYearOldLongDateDoesntMeetsCOPPARequirements ();
    void testThirteenYearOldLongDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDayShortLongDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldLongDateMeetsCOPPARequirements ();
    void testFourteenYearOldAndADayLongDateMeetsCOPPARequirements ();
    void testFifteenYearOldLongDateMeetsCOPPARequirements ();
    void testEighteenYearOldLongDateMeetsCOPPARequirements ();
    void testTwentyYearOldLongDateMeetsCOPPARequirements ();
    void testFiftyYearOldLongDateMeetsCOPPARequirements ();
    void testHundredYearOldLongDateMeetsCOPPARequirements ();
    // AgeMeetsCOPPARequirements (QString birthdate)
    void testZeroYearOldStringDateDoesntMeetsCOPPARequirements();
    void testOneYearOldStringDateDoesntMeetsCOPPARequirements ();
    void testFiveYearOldStringDateDoesntMeetsCOPPARequirements ();
    void testThirteenYearOldStringDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements ();
    void testFourteenYearOldStringDateMeetsCOPPARequirements ();
    void testFourteenYearOldAndADayStringDateMeetsCOPPARequirements ();
    void testFifteenYearOldStringDateMeetsCOPPARequirements ();
    void testEighteenYearOldStringDateMeetsCOPPARequirements ();
    void testTwentyYearOldStringDateMeetsCOPPARequirements ();
    void testFiftyYearOldStringDateMeetsCOPPARequirements ();
    void testHundredYearOldStringDateMeetsCOPPARequirements ();
public:
    explicit COPPATests() : QTestSuite() {};
    virtual const char * Name();
};


#endif /* COPPATESTS_H_ */
