/*
 * coppa.h
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#ifndef COPPA_H_
#define COPPA_H_

#include <QtCore/QDateTime>
#include <QtCore/QString>

namespace just10
{
    namespace coppa
    {

        /*!
         * Determines whether the given timestamp corresponds to an age that meets COPPA requirements
         * @param birthdate date of birth as a unix timestamp (millis from epoch)
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool ageMeetsCOPPARequirements(const long birthdate);

        bool ageMeetsCOPPARequirements(const QString &birthdate);

        bool ageMeetsCOPPARequirements(const QDate &birthdate);

        bool ageMeetsCOPPARequirements(const QDateTime &birthdate)
        {
            return ageMeetsCOPPARequirements(birthdate.date());
        }
    }
}
#endif /* COPPA_H_ */
