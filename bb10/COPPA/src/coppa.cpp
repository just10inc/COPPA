/*
 * coppa.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <coppa.h>
#include <QtCore/QDateTime>
#include <QtCore/QString>

namespace just10
{
    namespace coppa
    {
        const int MINIMUM_AGE = 14;
    }
}

        bool just10::coppa::ageMeetsCOPPARequirements(const long birthdate)
        {
            return false;
        }

        bool just10::coppa::ageMeetsCOPPARequirements(const QString &birthdate)
        {
            return false;
        }

        bool just10::coppa::ageMeetsCOPPARequirements(const QDate &birthdate)
        {
            return false;
        }


