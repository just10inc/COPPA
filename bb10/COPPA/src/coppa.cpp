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
 * coppa.cpp
 *
 *  Created on: May 31, 2016
 *      Author: mahramf
 */

#include <coppa.h>
#include <time_utils.h>
#include <QtCore/QDateTime>
#include <QtCore/QString>

namespace just10
{
    namespace coppa
    {
        const int MINIMUM_AGE = 14;

        bool ageMeetsCOPPARequirements(const QString &birthdate)
        {
            return ageMeetsCOPPARequirements(util::fromYYYYMMDD(birthdate));
        }

        bool ageMeetsCOPPARequirements(const QDate &birthdate)
        {
            return util::getAge(birthdate) >= MINIMUM_AGE;
        }

        bool ageMeetsCOPPARequirements(const qint64 birthdate)
        {
            return ageMeetsCOPPARequirements(QDateTime::fromMSecsSinceEpoch(birthdate).date());
        }

        bool ageMeetsCOPPARequirements(const QDateTime &birthdate)
        {
            return ageMeetsCOPPARequirements(birthdate.date());
        }
    }
}

