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
//  NSDate_COPPAExtensions.h
//  COPPA
//
//  Created by Mahram Z. Foadi on 2016-06-06.
//  Copyright © 2016 just10. All rights reserved.
//

#import <Foundation/Foundation.h>

extern const NSCalendarUnit DEFAULT_DATE_COMPONENTS;

@interface NSDate (COPPAExtensions)

+ (NSCalendar *) currentCalendar;

- (NSInteger) calculateAge;

- (NSString*) toyyyyMMdd;

+ (NSDate*) fromString: (NSString*) yyyyMMdd;

@end
