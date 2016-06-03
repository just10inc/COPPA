/*
 * time_utils.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <time_utils.h>

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
