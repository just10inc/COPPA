/*
 * coppa.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <coppa.h>
#include <private/time_utils.h>
#include <QtCore/QDateTime>
#include <QtCore/QString>

namespace just10 {
    namespace coppa {
        const int MINIMUM_AGE = 14;

        bool ageMeetsCOPPARequirements(const QString &birthdate)
        {
            return ageMeetsCOPPARequirements(util::fromYYYYMMDD(birthdate));
        }

        bool ageMeetsCOPPARequirements(const QDate &birthdate)
        {
            return util::getAge(birthdate) >= MINIMUM_AGE;
        }
    }
}


