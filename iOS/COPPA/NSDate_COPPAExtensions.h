//
//  NSDate_COPPAExtensions.h
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-06.
//  Copyright © 2016 just10. All rights reserved.
//

#import <Foundation/Foundation.h>

extern const NSCalendarUnit DEFAULT_DATE_COMPONENTS;

@interface NSDate (COPPAExtensions)

+ (NSCalendar *) currentCalendar;

- (NSInteger) calculateAge;

+ (NSDate*) fromString: (NSString*) yyyyMMdd;

@end
