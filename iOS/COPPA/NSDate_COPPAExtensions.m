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
//  NSDate_COPPAExtensions.m
//  COPPA
//
//  Created by Mahram Z. Foadi on 2016-06-06.
//  Copyright © 2016 just10. All rights reserved.
//

#import "NSDate_COPPAExtensions.h"

@implementation NSDate (COPPAExtensions)

const NSCalendarUnit DEFAULT_DATE_COMPONENTS = NSCalendarUnitYear | NSCalendarUnitMonth | NSCalendarUnitDay;
const NSString* YYYYMMDD_FORMAT = @"yyyyMMdd";

+ (NSCalendar *) currentCalendar {
    static NSCalendar *cc = nil;
    
    if (!cc)
        cc = [NSCalendar autoupdatingCurrentCalendar];
    
    return cc;    
}

+ (NSDateFormatter*) yyyyMMddFormatter {
    static NSDateFormatter* df = nil;
    
    if (!df) {
        df = [[NSDateFormatter alloc] init];
        [df setDateFormat:YYYYMMDD_FORMAT];
    }
    
    return df;
}

+ (NSDate*) fromString: (NSString*) yyyyMMdd {
    
    
    if (!yyyyMMdd) [NSException raise:@"nil input" format:@"Date must be provided in %@ format", YYYYMMDD_FORMAT];
    
    if ([yyyyMMdd length] != [YYYYMMDD_FORMAT length])
        [NSException raise:@"invalid input" format:@"Invalid date format."];
    
    NSDate* date = [[NSDate yyyyMMddFormatter] dateFromString:yyyyMMdd];
    
    if (!date) [NSException raise:@"Invalid input" format:@"Unable to parse '%@' as a date", yyyyMMdd];
    
    return date;
}

- (NSString*) toyyyyMMdd {
    return [[NSDate yyyyMMddFormatter] stringFromDate:self];
}

@end

