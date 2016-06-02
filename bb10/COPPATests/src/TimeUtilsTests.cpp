/*
 * TimeUtilsTests.cpp
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#include "TimeUtilsTests.h"
#include <qtest.h>

char * TimeUtilsTests::Name() {
    return "TimeUtils Tests";
}

void TimeUtilsTests::failTimeUtilsTestsBecause () {
    QVERIFY("bob" == "sally");
}
