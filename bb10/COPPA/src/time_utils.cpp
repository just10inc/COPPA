/*
 * time_utils.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <private/time_utils.h>

namespace just10
{
    namespace coppa
    {
        namespace util
        {
            const QString YYYYMMDD_FORMAT = "yyyyMMdd";

            QDateTime now()
            {
                return QDateTime::currentDateTime();
            }

            QDate today()
            {
                return now().date();
            }

            QDate fromYYYYMMDD (const QString& yyyymmdd) {
                return QDate::fromString(yyyymmdd, YYYYMMDD_FORMAT);
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
