//
//  COPPA.m
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import "NSDate_COPPAExtensions.h"
#import "COPPA.h"

@implementation COPPA

const NSCalendarUnit CALENDAR_FLAGS = NSCalendarUnitYear | NSCalendarUnitMonth | NSCalendarUnitDay;

const NSInteger MINIMUM_AGE = 14;

+ (bool) ageMeetsCOPPARequirementsWithSeconds: (long) secondsFromEpoch {
    return [COPPA ageMeetsCOPPARequirementsWithDate:[NSDate dateWithTimeIntervalSince1970:secondsFromEpoch]];
}

+ (bool) ageMeetsCOPPARequirementsWithDate: (NSDate *) birthdate {
    return [birthdate calculateAge] >= MINIMUM_AGE;
}

+ (bool) ageMeetsCOPPARequirementsWithYYYYMMdd: (NSString *) birthdate {
    return [COPPA ageMeetsCOPPARequirementsWithDate:[NSDate fromString:birthdate]];
}

@end
