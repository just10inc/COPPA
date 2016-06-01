/*
 * QTestSuite.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <string.h>
#include <algorithm>
#include "QTestSuite.h"

using namespace std;

const size_t MAX_NAME_LEN = 32;

std::vector<QObject*> QTestSuite::mSuites;

QTestSuite::QTestSuite(const char* const name) : QObject()
{
    const size_t len = min (MAX_NAME_LEN, strlen (name));
    mName = strncpy (new char[len + 1], name, len);

    mSuites.push_back(this);
}

QTestSuite::~QTestSuite() {
    delete mName;
    mName = NULL;
}
