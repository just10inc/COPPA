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
var COPPA = {};

COPPA.ageMeetsCOPPARequirements = function (birthdate) {
    var MINIMUM_AGE = 14;

    if (null == birthdate)
        throw "No birthdate provided";

    var dob = new Date(Date.parse(birthdate));

    if (isNaN(dob))
        throw "Invalid birthdate provided: '" + birthdate + "'";

    var today = new Date();

    var age = today.getUTCFullYear() - dob.getUTCFullYear();

    var birthMonth = dob.getUTCMonth();
    var thisMonth = today.getUTCMonth();

    if (birthMonth > thisMonth || (birthMonth == thisMonth && dob.getUTCDate() > today.getUTCDate())) {
        age--;
    }

    return age >= MINIMUM_AGE;
};
