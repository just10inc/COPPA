/*
 * QTestSuite.h
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#ifndef QTESTSUITE_H_
#define QTESTSUITE_H_

#include <QObject>
#include <vector>

class QTestSuite: public QObject
{
    Q_OBJECT

public:
    QTestSuite();

    virtual char * Name() = 0;
};

#endif /* QTESTSUITE_H_ */
