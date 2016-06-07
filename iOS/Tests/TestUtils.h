//
//  TestUtils.m
//  COPPA
//
//  Created by Mahram Zojajpour Foadi on 2016-06-06.
//  Copyright © 2016 just10. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface TestUtils : NSObject

+ (NSDate*) moveDateByYears: (int)years Months:(int) months Days:(int) days;

+ (long) moveDateAsLongByYears: (int)years Months:(int) months Days:(int) days;

+ (NSString*) moveDateAsStringByYears: (int)years Months:(int) months Days:(int) days;

@end