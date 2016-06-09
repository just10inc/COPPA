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
//  TestUtils.m
//  COPPA
//
//  Created by Mahram Z. Foadi on 2016-06-06.
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

+ (long) moveDateAsLongByYears: (int)years Months:(int) months Days:(int) days {
    return [[TestUtils moveDateByYears:years Months:months Days:days] timeIntervalSince1970];
}

+ (NSString*) moveDateAsStringByYears: (int)years Months:(int) months Days:(int) days {
    return [[TestUtils moveDateByYears:years Months:months Days:days] toyyyyMMdd];
}

@end