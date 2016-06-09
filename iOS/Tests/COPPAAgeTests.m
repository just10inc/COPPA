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
//
//  COPPAAgeTests.m
//  COPPA Age ßTests
//
//  Created by Mahram Z. Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "COPPA.h"
#import "TestUtils.h"

@interface COPPAAgeTests : XCTestCase

@end

@implementation COPPAAgeTests

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void) testZeroYearOldNSDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[NSDate date]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:0 Months:0 Days:-15]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:0 Months:-5 Days:0]]);
}

- (void) testOneYearOldNSDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-1 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-1 Months:3 Days:0]]);
    }

- (void) testFiveYearOldNSDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-5 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-5 Months:6 Days:4]]);
}

- (void) testThirteenYearOldNSDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-13 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-13 Months:7 Days:0]]);
}

- (void) testFourteenYearOldDayShortNSDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-14 Months:0 Days:1]]);
}

- (void) testFourteenYearOldNSDateMeetsCOPPARequirements 
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-14 Months:0 Days:0]]);
}

- (void) testFourteenYearOldAndADayNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-14 Months:0 Days:-1]]);
}

- (void) testFifteenYearOldNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-15 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-15 Months:0 Days:-20]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-15 Months:-5 Days:-25]]);
}

- (void) testEighteenYearOldNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-18 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-18 Months:0 Days:-17]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-18 Months:-8 Days:-12]]);
}

- (void) testTwentyYearOldNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-20 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-20 Months:0 Days:-23]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-20 Months:-2 Days:-19]]);
}

- (void) testFiftyYearOldNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-50 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-50 Months:0 Days:-11]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-50 Months:-10 Days:1]]);
}

- (void) testHundredYearOldNSDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-100 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-100 Months:0 Days:-19]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithDate:[TestUtils moveDateByYears:-100 Months:-3 Days:-13]]);
}

// ageMeetsCOPPARequirements (long birthdate)

- (void) testZeroYearOldLongDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:0 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:0 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:0 Months:0 Days:0]]);
}

- (void) testOneYearOldLongDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-1 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-1 Months:3 Days:0]]);
}

- (void) testFiveYearOldLongDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-5 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-5 Months:6 Days:4]]);
}

- (void) testThirteenYearOldLongDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-13 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-13 Months:7 Days:0]]);
}

- (void) testFourteenYearOldDayShortLongDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-14 Months:0 Days:1]]);
}

- (void) testFourteenYearOldLongDateMeetsCOPPARequirements
{
     XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-14 Months:0 Days:0]]);
}

- (void) testFourteenYearOldAndADayLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-14 Months:0 Days:-1]]);
}

- (void) testFifteenYearOldLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-15 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-15 Months:0 Days:-20]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-15 Months:-4 Days:-12]]);
}

- (void) testEighteenYearOldLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-18 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-18 Months:0 Days:-7]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-18 Months:-8 Days:-12]]);
}

- (void) testTwentyYearOldLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-20 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-20 Months:0 Days:-25]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-20 Months:-2 Days:-15]]);
}

- (void) testFiftyYearOldLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-50 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-50 Months:0 Days:-13]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-50 Months:-10 Days:1]]);
}

- (void) testHundredYearOldLongDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-100 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-100 Months:0 Days:-19]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithSeconds:[TestUtils moveDateAsLongByYears:-100 Months:-3 Days:-21]]);
}

// ageMeetsCOPPARequirements (string yyyymmdd)

- (void) testZeroYearOldStringDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:0 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:0 Months:0 Days:-15]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:0 Months:-5 Days:0]]);
}

- (void) testOneYearOldStringDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-1 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-1 Months:3 Days:0]]);
}

- (void) testFiveYearOldStringDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-5 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-5 Months:6 Days:4]]);
    }

- (void) testThirteenYearOldStringDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-13 Months:0 Days:0]]);
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-13 Months:7 Days:0]]);
}

- (void) testFourteenYearOldDayShortStringDateDoesntMeetsCOPPARequirements
{
    XCTAssertFalse ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-14 Months:0 Days:1]]);
}

- (void) testFourteenYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-14 Months:0 Days:0]]);
}

- (void) testFourteenYearOldAndADayStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-14 Months:0 Days:-1]]);
}

- (void) testFifteenYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-15 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-15 Months:0 Days:-20]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-15 Months:-4 Days:-27]]);
}

- (void) testEighteenYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-18 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-18 Months:0 Days:-7]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-18 Months:-8 Days:-17]]);
}

- (void) testTwentyYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-20 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-20 Months:0 Days:-23]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-20 Months:-2 Days:-19]]);
}

- (void) testFiftyYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-50 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-50 Months:0 Days:-13]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-50 Months:-10 Days:3]]);
}

- (void) testHundredYearOldStringDateMeetsCOPPARequirements
{
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-100 Months:0 Days:0]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-100 Months:0 Days:-19]]);
    XCTAssertTrue ([COPPA ageMeetsCOPPARequirementsWithYYYYMMdd:[TestUtils moveDateAsStringByYears:-100 Months:-3 Days:7]]);
}

@end
