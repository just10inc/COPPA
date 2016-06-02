/*
 * TimeUtilsTests.h
 *
 *  Created on: Jun 1, 2016
 *      Author: mahramf
 */

#ifndef COPPATESTS_H_
#define COPPATESTS_H_

#include "QtestSuite.h"

class COPPATests: public QTestSuite
{
    Q_OBJECT
private slots:
    void failCOPPATestsBecause ();
public:
    explicit COPPATests() : QTestSuite() {};
    virtual char * Name();
};


#endif /* COPPATESTS_H_ */
