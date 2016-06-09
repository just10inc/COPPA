/**
 * Created by mahramf on 2016-06-08.
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
        assert.equal(true, lib.ageMeetsCOPPARequirements != null , 'function ageMeetsCOPPARequirements is undefined');
        assert.equal('function', typeof lib.ageMeetsCOPPARequirements, 'ageMeetsCOPPARequirements is not a function');
    });

    it('Zero years old does not meet COPPA requirements', function () {
        assert.equal(true, lib.ageMeetsCOPPARequirements("1979 09 22"));
    });

    it('One year old does not meet COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('5 year old does not meet COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('13 year old does not meet COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('A day short of 14 year old does not meet COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('14 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('14 & change year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('15 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('18 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('20 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('50 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });

    it('100 year old meets COPPA requirements', function () {
        assert.equal(false, true, 'not implemented');
    });
});