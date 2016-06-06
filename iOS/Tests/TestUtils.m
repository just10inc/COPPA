//
//  TestUtils.m
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-06.
//  Copyright © 2016 just10. All rights reserved.
//

#import "TestUtils.h"
#import "NSDate_COPPAExtensions.h"

@implementation TestUtils

+ (NSDate*) moveDateByYears: (int)years Months:(int) months Days:(int) days {
    NSDateComponents* dc = [[NSDateComponents alloc] init];
    [dc setYear: years];
    [dc setMonth:months];
    [dc setDay:days];
    
    return [[NSDate currentCalendar] dateByAddingComponents:dc toDate:[NSDate date] options:NSCalendarWrapComponents];
}

@end