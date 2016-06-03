/*
 * time_utils.h
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#ifndef TIME_UTILS_H_
#define TIME_UTILS_H_

#include <QtCore/QDateTime>

namespace just10
{
    namespace coppa
    {
        namespace util
        {
            QDateTime now();

            QDate today();

            QDate fromYYYYMMDD (const QString& yyyymmdd);

            int getAge(const QDate &birthdate);
        }
    }
}
#endif /* TIME_UTILS_H_ */
