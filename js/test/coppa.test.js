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
var assert = require ('chai').assert;
var vanilla = require('./../src/vanilla');
var coppa_lib = vanilla.require('./../src/coppa.js',['COPPA'])
var lib = coppa_lib.COPPA;

function moveDate (years, months, days) {
    var date = new Date();
    var year = date.getUTCFullYear();
    var month = date.getUTCMonth();
    var day = date.getUTCDate();
    date.setHours(0, 0, 0, 0);

    if (years != 0) date.setUTCFullYear(year + years);
    if (months != 0) date.setUTCMonth(month + months);
    if (days != 0) date.setUTCDate(day + days);
    return date;
}

describe ('moveDate', function () {
    it ('Date not moved is today', function () {
        var today = new Date();
        var notMoved = moveDate (0, 0, 0);
        assert.equal(today.getFullYear(), notMoved.getFullYear());
        assert.equal(today.getMonth(), notMoved.getMonth());
        assert.equal(today.getDate(), notMoved.getDate());
    });

    it ('Date moved by -1 years is last year', function () {
        var today = new Date();
        var moved = moveDate (-1, 0, 0);
        assert.equal(today.getFullYear() - 1, moved.getFullYear());
        assert.equal(today.getMonth(), moved.getMonth());
        assert.equal(today.getDate(), moved.getDate());
    });

    it ('Date moved by 1 year is next year', function () {
        var today = new Date();
        var moved = moveDate (1, 0, 0);
        assert.equal(today.getFullYear() + 1, moved.getFullYear());
        assert.equal(today.getMonth(), moved.getMonth());
        assert.equal(today.getDate(), moved.getDate());
    });

    // this will fail on the last day of the month
    it ('Date moved by 1 day is tomorrow', function () {
        var today = new Date();
        var moved = moveDate (0, 0, 1);
        assert.equal(today.getFullYear(), moved.getFullYear());
        assert.equal(today.getMonth(), moved.getMonth());
        assert.equal(today.getDate() + 1, moved.getDate());
    });

    // this will fail on the last day of the month
    it ('Date moved by -1 days is yesterday', function () {
        var today = new Date();
        var moved = moveDate (0, 0, -1);
        assert.equal(today.getFullYear(), moved.getFullYear());
        assert.equal(today.getMonth(), moved.getMonth());
        assert.equal(today.getDate() - 1, moved.getDate());
    });
});

describe('COPPA', function() {
    it('age check function is defined', function () {
        assert.equal(lib.ageMeetsCOPPARequirements != null , true, 'function ageMeetsCOPPARequirements is undefined');
        assert.equal(typeof lib.ageMeetsCOPPARequirements, 'function', 'ageMeetsCOPPARequirements is not a function');
    });

    it('Zero years old does not meet COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(0,0,0)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(0,0,-11)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(0,-4,-17)), false);
    });

    it('One year old does not meet COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-1,0,0)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-1,0,-27)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-1,-3,-15)), false);
    });

    it('5 year old does not meet COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-5,0,0)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-5,0,-9)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-5,-4,15)), false);
    });

    it('13 year old does not meet COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-13,0,0)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-13,0,-18)), false);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-13,-6,-10)), false);
    });

    it('A day short of 14 years old does not meet COPPA requirements', function () {
        assert.equal(lib.ageMeetsCOPPARequirements(moveDate(-14,0,1)), false);
    });

    it('14 year old meets COPPA requirements', function () {
        assert.equal(lib.ageMeetsCOPPARequirements(moveDate(-14,0,0)), true);
    });

    it('14 & change year old meets COPPA requirements', function () {
        assert.equal(lib.ageMeetsCOPPARequirements(moveDate(-14,-2,0)), true);
        assert.equal(lib.ageMeetsCOPPARequirements(moveDate(-14,-7,3)), true);
    });

    it('15 year old meets COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-15,0,0)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-15,0,-28)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-15,-2,-17)), true);
    });

    it('18 year old meets COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-18,0,0)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-18,0,-8)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-18,-5,7)), true);
    });

    it('20 year old meets COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-20,0,0)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-20,0,-11)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-20,-3,27)), true);
    });

    it('50 year old meets COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-50,0,0)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-50,0,-20)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-50,-3,13)), true);
    });

    it('100 year old meets COPPA requirements', function () {
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-100,0,0)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-100,0,-5)), true);
        assert.equal( lib.ageMeetsCOPPARequirements(moveDate(-100,-8,20)), true);
    });
});