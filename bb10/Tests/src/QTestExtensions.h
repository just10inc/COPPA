/*
 * QTestExtensions.h
 *
 *  Created on: Jun 2, 2016
 *      Author: mahramf
 */

#ifndef QTESTEXTENSIONS_H_
#define QTESTEXTENSIONS_H_

#include <QTest.h>

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


#endif /* QTESTEXTENSIONS_H_ */
