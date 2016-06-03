/*
 * TimeUtilsTests.h
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#ifndef TIMEUTILSTESTS_H_
#define TIMEUTILSTESTS_H_

#include <QObject>
#include "QtestSuite.h"
#include <time_utils.h>

class TimeUtilsTests: public QTestSuite
{
    Q_OBJECT
private slots:
    void testQDateFromString ();
    void testQDateFromEmptyStringThrows ();
    void testQDateFromNonDigitStringThrows ();
    void testQDateFromNonDigitYearStringThrows ();
    void testQDateFromNonDigitMonthStringThrows ();
    void testQDateFromNonDigitDayStringThrows ();
    void testInvalidQDateFromStringThrows ();
    void testQDateFromTooShortString ();
    void testQDateFromTooLongString ();
    void testBornTodayIsZeroAged ();
    void testBornNowIsZeroAged ();
    void testAgesByAddedDates();
public:
    explicit TimeUtilsTests() : QTestSuite() {};
    virtual const char * Name();
};

#endif /* TIMEUTILSTESTS_H_ */
