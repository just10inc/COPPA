/*
 * TestUtils.cpp
 *
 *  Created on: Jun 2, 2016
 *      Author: mahramf
 */

#include <qdatetime.h>
#include <time_utils.h>
#include "TestUtils.h"

using namespace just10::coppa::util;

QDate moveDate (const int years, const int months, const int days) {
    return moveTime(years, months, days).date();
}

QDateTime moveTime (const int years, const int months, const int days) {
    return now().addYears(years).addMonths(months).addDays(days);
}

