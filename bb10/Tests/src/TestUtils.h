/*
 * TestUtils.h
 *
 *  Created on: Jun 2, 2016
 *      Author: mahramf
 */

#ifndef TESTUTILS_H_
#define TESTUTILS_H_

#include <QtTest>

QDate moveDate (const int years = 0, const int months = 0, const int days = 0);

QDateTime moveTime (const int years = 0, const int months = 0, const int days = 0);

#define ASSERT_FALSE( expr ) QVERIFY (!expr)
#define ASSERT_TRUE( expr ) QVERIFY (expr)

#define EXPECT_THROW( func, exceptionClass ) \
{ \
    bool caught = false; \
    try { \
        (func); \
    } catch ( exceptionClass ) { \
        caught = true; \
    } catch ( ... ) { QFAIL("Wrong exception type thrown"); } \
    if (!caught) QFAIL ("No exception thrown");\
}


#endif /* TESTUTILS_H_ */
