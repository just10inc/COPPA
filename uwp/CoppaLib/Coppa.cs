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
 
using System;

namespace Just10
{
    /// <summary>
    /// Provides static COPPA compliancy age-check methods
    /// </summary>
    public static class COPPA
    {
        private const int MINIMUM_AGE = 14;

        /// <summary>
        /// Determines if the provided birthdate provides an age that satisfies COPPA requirements
        /// </summary>
        /// <param name="birthdate">Birthdate as DateTime instance</param>
        /// <returns>True if the calculated age meets COPPA requirements &amp; False otherwise</returns>
        public static bool AgeMeetsCOPPARequirements (DateTime birthdate)
        {
            if (birthdate == null)
                throw new ArgumentNullException ("birthdate");

            return birthdate.GetAge () >= MINIMUM_AGE;
        }

        /// <summary>
        /// Determines if the provided birthdate provides an age that satisfies COPPA requirements
        /// </summary>
        /// <param name="birthdate">Birthdate as Unix timestamp in UTC</param>
        /// <returns>True if the calculated age meets COPPA requirements &amp; False otherwise</returns>
        public static bool AgeMeetsCOPPARequirements (long birthdate)
        {
            return AgeMeetsCOPPARequirements(DateTimeExtensions.FromMillis (birthdate));
        }

        /// <summary>
        /// Determines if the provided birthdate provides an age that satisfies COPPA requirements
        /// </summary>
        /// <param name="yyyymmdd">Birthdate as a YYYYMMDD date string</param>
        /// <returns>True if the calculated age meets COPPA requirements &amp; False otherwise</returns>
        public static bool AgeMeetsCOPPARequirements (string yyyymmdd)
        {
            return AgeMeetsCOPPARequirements(DateTimeExtensions.FromString(yyyymmdd));
        }

    }
}
