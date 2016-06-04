//
//  COPPA.h
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface COPPA : NSObject

+ (bool) ageMeetsCOPPARequirementsWithSeconds: (long) birthdate;
+ (bool) ageMeetsCOPPARequirementsWithDate: (NSDate *) birthdate;
+ (bool) ageMeetsCOPPARequirementsWithYYYYMMdd: (NSString *) birthdate;

@end
