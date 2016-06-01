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

class QTestSuite : public QObject
{
    Q_OBJECT
public:
    static std::vector<QObject*> mSuites;

public:
    explicit QTestSuite(const char* const name);
    ~QTestSuite();

private:
    char const* mName;
};

#endif /* QTESTSUITE_H_ */
