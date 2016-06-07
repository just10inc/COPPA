//
//  NSDate_COPPAExtensions.m
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-06.
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

- (NSInteger) calculateAge {
    NSCalendar* cal = [NSCalendar currentCalendar];
    NSDateComponents* today = [cal components:DEFAULT_DATE_COMPONENTS fromDate:[NSDate date]];
    NSDateComponents* birthdate = [cal components:DEFAULT_DATE_COMPONENTS fromDate:self];
    
    const NSInteger birthYear = [birthdate year];
    const NSInteger birthMonth = [birthdate month];
    const NSInteger birthDay = [birthdate day];
    const NSInteger thisYear = [today year];
    const NSInteger thisMonth = [today month];
    const NSInteger thisDay = [today day];
    
    const bool notReachedBDThisYear = (birthMonth > thisMonth ||
                                       (birthMonth == thisMonth && birthDay > thisDay));
    
    return thisYear - birthYear - (notReachedBDThisYear ? 1 : 0);
}

- (NSString*) toyyyyMMdd {
    return [[NSDate yyyyMMddFormatter] stringFromDate:self];
}

@end

