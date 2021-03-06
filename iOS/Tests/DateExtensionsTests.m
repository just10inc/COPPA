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
//  DateExtensionsTests.m
//  NSDate Extensions Tests
//
//  Created by Mahram Z. Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "NSDate_COPPAExtensions.h"
#import "TestUtils.h"

@interface DateExtensionsTests : XCTestCase

@end

#define XCTAssertDate(date, y, m, d) [self assertDate:date hasYear:y hasMonth:m hasDay:d];

@implementation DateExtensionsTests

- (void)setUp {
    [super setUp];
}

- (void)tearDown {
    [super tearDown];
}

-(void) assertDate:(NSDate*) date hasYear:(int)year hasMonth: (int)month hasDay:(int)day {
    NSDateComponents* c = [[NSDate currentCalendar] components:DEFAULT_DATE_COMPONENTS fromDate:date];
    
    XCTAssertEqual(year, [c year]);
    XCTAssertEqual(month, [c month]);
    XCTAssertEqual(day, [c day]);
}

- (void)testDateFromStringParsesCorrectly {
    XCTAssertDate([NSDate fromString:@"19790922"], 1979, 9, 22);
    XCTAssertDate([NSDate fromString:@"20161107"], 2016, 11, 7);
}

- (void)testDateFromNilStringThrows {
    XCTAssertThrows([NSDate fromString:nil]);
}

- (void)testDateFromStringMissingYearThrows {
    XCTAssertThrows([NSDate fromString:@"0916"]);
}

- (void)testDateFromShortStringThrows {
    XCTAssertThrows([NSDate fromString:@"2160916"]);
}

- (void)testDateFromTooLongStringThrows {
    XCTAssertThrows([NSDate fromString:@"201660916"]);
}

- (void)testDateFromNonNumericStringThrows {
    XCTAssertThrows([NSDate fromString:@"bobsurun"]);
}

- (void)testDateFromStringNonNumericYearThrows {
    XCTAssertThrows([NSDate fromString:@"2Ol60216"]);
}

- (void)testDateFromStringNonNumericMonthThrows {
    XCTAssertThrows([NSDate fromString:@"2026O216"]);
}

- (void)testDateFromStringNonNumericDayThrows {
    XCTAssertThrows([NSDate fromString:@"2026021g"]);
}

@end
