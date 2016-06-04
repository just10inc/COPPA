//
//  COPPA.m
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import "COPPA.h"

@implementation COPPA

const NSCalendarUnit CALENDAR_FLAGS = NSCalendarUnitYear | NSCalendarUnitMonth | NSCalendarUnitDay;

+ (NSInteger) calculateAge: (NSDate*) forBirthdate {
    NSCalendar* cal = [NSCalendar currentCalendar];
    NSDateComponents* today = [cal components:CALENDAR_FLAGS fromDate:[NSDate date]];
    NSDateComponents* birthdate = [cal components:CALENDAR_FLAGS fromDate:forBirthdate];
    
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

+ (bool) ageMeetsCOPPARequirementsWithSeconds: (long) birthdate {
    return false;
}

+ (bool) ageMeetsCOPPARequirementsWithDate: (NSDate *) birthdate {
    return false;
}

+ (bool) ageMeetsCOPPARequirementsWithYYYYMMdd: (NSString *) birthdate {
    return false;
}

@end
