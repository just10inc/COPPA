/**
 Copyright 2016 Just10 Inc.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
 
/*
 * time_utils.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <time_utils.h>
#include <QDebug>

namespace just10
{
    namespace coppa
    {
        namespace util
        {
            static const QString YYYYMMDD_FORMAT = "yyyyMMdd";

            QDateTime now()
            {
                return QDateTime::currentDateTime();
            }

            QDate today()
            {
                return now().date();
            }

            QDate fromYYYYMMDD (const QString& yyyymmdd) {
                if (yyyymmdd.length() != YYYYMMDD_FORMAT.length())
                    throw "Invalid input. Provide date as yyyyMMdd (e.g. June 2, 2016 = '20160602')";

                for (QString::const_iterator chr (yyyymmdd.begin()); chr != yyyymmdd.end(); chr++) {
                    if (!chr->isDigit())
                        throw "Non digit character in input string.";
                }

                const QDate result = QDate::fromString(yyyymmdd, YYYYMMDD_FORMAT);

                if (!result.isValid())
                    throw "Invalid date input";

                return result;
            }

            int getAge(const QDate &birthdate)
            {
                const QDate now = today();

                const int birthYear = birthdate.year();
                const int birthMonth = birthdate.month();
                const int birthDay = birthdate.day();

                const int thisYear = now.year();
                const int thisMonth = now.month();
                const int thisDay = now.day();

                const bool notReachedBDThisYear = (birthMonth > thisMonth
                        || (birthMonth == thisMonth && birthDay > thisDay));

                return thisYear - birthYear - (notReachedBDThisYear ? 1 : 0);
            }
        }
    }
}
