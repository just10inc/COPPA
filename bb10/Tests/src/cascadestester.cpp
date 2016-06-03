/****************************************************************************
 **
 ** Portions Copyright (C) 2014 BlackBerry Limited.
 ** Copyright (C) 2011 Nokia Corporation and/or its subsidiary(-ies).
 ** All rights reserved.
 ** Contact: Research In Motion Ltd. (http://www.rim.com/company/contact/)
 ** Contact: Nokia Corporation (qt-info@nokia.com)
 **
 ** This file is part of the examples of the BB10 Platform and is derived
 ** from a similar file that is part of the Qt Toolkit.
 **
 ** You may use this file under the terms of the BSD license as follows:
 **
 ** "Redistribution and use in source and binary forms, with or without
 ** modification, are permitted provided that the following conditions are
 ** met:
 **   * Redistributions of source code must retain the above copyright
 **     notice, this list of conditions and the following disclaimer.
 **   * Redistributions in binary form must reproduce the above copyright
 **     notice, this list of conditions and the following disclaimer in
 **     the documentation and/or other materials provided with the
 **     distribution.
 **   * Neither the name of Research In Motion, nor the name of Nokia
 **     Corporation and its Subsidiary(-ies), nor the names of its
 **     contributors may be used to endorse or promote products
 **     derived from this software without specific prior written
 **     permission.
 **
 ** THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 ** "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 ** LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 ** A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 ** OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 ** SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 ** LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 ** DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 ** THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 ** (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 ** OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE."
 **
 ****************************************************************************/

#include "cascadestester.hpp"

#include <bb/cascades/Application>

#include <QtTest/QTest>

CascadesTester::CascadesTester()
{

}

CascadesTester::~CascadesTester()
{
    qDebug("Releasing %d test suites...", mSuites.size());

    while (mSuites.size() > 0) {
        QTestSuite* back = mSuites.back();
        mSuites.pop_back();
        qDebug("Releasing '%s'", back->Name());
        delete back;
    }
}

void CascadesTester::addTestSuite(QTestSuite* suite)
{
    mSuites.push_back(suite);
    qDebug("Registered %s for execution", suite->Name());
}

void CascadesTester::startTest()
{
    const int numSuites = mSuites.size();
    int failedTests = 0;
    int failedSuites = 0;
    int current = 0;

    std::vector<QTestSuite*>::iterator suites;

    for (suites = mSuites.begin(); suites != mSuites.end(); suites++) {
        QTestSuite* suite = *suites;

        qDebug("Executing test suite '%s' (%d/%d)", suite->Name(), ++current, numSuites);

        int failures = QTest::qExec(suite);

        if (failures > 0) {
            failedSuites++;
            failedTests += failures;
        }

        if (failures == 0)
            qDebug("[PASS] %s: All tests passed.", suite->Name());
        else
            qDebug("[FAIL] %s: %d test%s failed.", suite->Name(), failures, failures > 1 ? "s":"");
    }

    // terminate application
    bb::cascades::Application::exit(failedSuites);

    qDebug();

    if (failedSuites == 0)
        qDebug("All tests passed. Good job.");
    else
        qDebug("%d tests failed in %d of %d suites.", failedTests, failedSuites, numSuites);
}
