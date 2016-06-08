/**
 * Created by mahra on 2016-06-07.
 */

var MINIMUM_AGE = 14;

function ageMeetsCOPPARequirements (birthdate) {
    if (null == birthdate)
        throw "No birthdate provided";

    var dob = Date.parse(birthdate);

    if (isNaN(dob))
        throw "Invalid birthdate provided: " + birthdate;

    var today = new Date();

    var age = today.getYear() - dob.getYear();

    var birthMonth = dob.getMonth();
    var thisMonth = today.getMonth();

    if (birthMonth > thisMonth || (birthMonth == thisMonth && dob.getDay() > today.getDay())) {
        age--;
    }

    return age >= MINIMUM_AGE;
}
