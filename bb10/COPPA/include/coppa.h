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
         * @param birthdate date of birth as the number of milliseconds from epoch
         * @return true if the calculated age meets the minimum requirements and false otherwise.
         */
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const qint64 birthdate);

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
        bool COPPA_EXPORT ageMeetsCOPPARequirements(const QDateTime &birthdate);
    }
}
#endif /* COPPA_H_ */
