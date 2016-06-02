/*
 * TimeUtilsTests.h
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#ifndef TIMEUTILSTESTS_H_
#define TIMEUTILSTESTS_H_

#include "QtestSuite.h"

class TimeUtilsTests: public QTestSuite
{
    Q_OBJECT
private slots:
    void failTimeUtilsTestsBecause ();
public:
    explicit TimeUtilsTests() : QTestSuite() {};
    virtual char * Name();
};


#endif /* TIMEUTILSTESTS_H_ */
