// ******
// node vanilla.test.js
// ******

var vanilla = require('./../src/vanilla');
var coppa_lib = vanilla.require('./../src/coppa.js',['COPPA'])
console.log(coppa_lib.COPPA); // <-- this is COPPA()
console.log(coppa_lib.COPPA.ageMeetsCOPPARequirements(' March 12, 1990'));
