//
//  DateExtensionsTests.m
//  NSDate Extensions Tests
//
//  Created by Mahram Zojajpour Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "NSDate_COPPAExtensions.h"
#import "TestUtils.h"

@interface DateExtensionsTests : XCTestCase

- (void)testTodayZeroAge;
- (void)testAgesByAddDates;
- (void)testDateFromStringParsesCorrectly;
- (void)testDateFromNilStringThrows;
- (void)testDateFromStringMissingYearThrows;
- (void)testDateFromShortStringThrows;
- (void)testDateFromTooLongStringThrows;
- (void)testDateFromNonNumericStringThrows;
- (void)testDateFromStringNonNumericYearThrows;
- (void)testDateFromStringNonNumericMonthThrows;
- (void)testDateFromStringNonNumericDayThrows;

@end

#define XCTAssertDate(date, y, m, d) [self assertDate:date hasYear:y hasMonth:m hasDay:d];

@implementation DateExtensionsTests

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void)testTodayZeroAge {
    XCTAssertEqual(0, [[NSDate date] calculateAge]);
}

-(void) assertDate:(NSDate*) date hasYear:(int)year hasMonth: (int)month hasDay:(int)day {
    NSDateComponents* c = [[NSDate currentCalendar] components:DEFAULT_DATE_COMPONENTS fromDate:date];
    
    XCTAssertEqual(year, [c year]);
    XCTAssertEqual(month, [c month]);
    XCTAssertEqual(day, [c day]);
}

- (void)testAgesByAddDates {
    XCTAssertEqual ( 0, [[TestUtils moveDateByYears:0 Months:0 Days:0] calculateAge]);
    XCTAssertEqual ( 0, [[TestUtils moveDateByYears:0 Months:-3 Days:1] calculateAge]);
    XCTAssertEqual ( 0, [[TestUtils moveDateByYears:-1 Months:0 Days:1] calculateAge]);
    XCTAssertEqual ( -1, [[TestUtils moveDateByYears:0 Months:0 Days:10] calculateAge]);
    XCTAssertEqual ( 1, [[TestUtils moveDateByYears:-1 Months:0 Days:0] calculateAge]);
    XCTAssertEqual ( 4, [[TestUtils moveDateByYears:-5 Months:0 Days:1] calculateAge]);
    XCTAssertEqual ( 5, [[TestUtils moveDateByYears:-5 Months:0 Days:0] calculateAge]);
    XCTAssertEqual ( 5, [[TestUtils moveDateByYears:-5 Months:-2 Days:0] calculateAge]);
    XCTAssertEqual ( 10, [[TestUtils moveDateByYears:-10 Months:-2 Days:-10] calculateAge]);
    XCTAssertEqual ( 13, [[TestUtils moveDateByYears:-14 Months:0 Days:1] calculateAge]);
    XCTAssertEqual ( 14, [[TestUtils moveDateByYears:-14 Months:0 Days:0] calculateAge]);
    XCTAssertEqual ( 200, [[TestUtils moveDateByYears:-200 Months:0 Days:-2] calculateAge]);
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
