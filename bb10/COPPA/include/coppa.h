/*
 * coppa.h
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#ifndef COPPA_H_
#define COPPA_H_

#include "coppa_global.hpp"
#include <QtCore/QDateTime>
#include <QtCore/QString>

namespace just10
{
    namespace coppa
    {

        /*!
         * Determines whether the given date corresponds to an age that meets COPPA requirements
         * @param birthdate date of birth as a QDate instance
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const QDate &birthdate);

        /*!
         * Determines whether the given timestamp corresponds to an age that meets COPPA requirements
         * @param birthdate date of birth as a unix timestamp (millis from epoch)
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const long birthdate) {
            return ageMeetsCOPPARequirements (QDateTime::fromMSecsSinceEpoch(birthdate).date());
        }

        /*!
         * Determines whether the given date string corresponds to an age that meets COPPA requirements
         * @param birthdate date of birth as a yyyyMMdd string
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const QString &birthdate);

        /*!
         * Determines whether the given date corresponds to an age that meets COPPA requirements
         * @param birthdate date of birth as a QDateTime instance
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const QDateTime &birthdate)
        {
            return ageMeetsCOPPARequirements(birthdate.date());
        }
    }
}
#endif /* COPPA_H_ */
