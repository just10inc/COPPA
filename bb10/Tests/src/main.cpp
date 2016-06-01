/*
 * main.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <QtTest/QtTest>
#include <iostream>
#include "QTestSuite.h"

int main (int, char**) {
    int failedTests = 0;
    int failedSuites = 0;

    std::vector<QObject*>::iterator suites;

    for (suites = QTestSuite::mSuites.begin(); suites != QTestSuite::mSuites.end(); suites++) {
        int failures = QTest::qExec(*suites);

        if (failures != 0) {
            failedSuites++;
            failedTests += failures;
        }
    }

    if (failedSuites == 0) {
        printf("%d tests failed in %d suites.", failedTests, failedSuites);
    } else {
        printf("All tests passed. Good job.");
    }

    return failedSuites;
}



