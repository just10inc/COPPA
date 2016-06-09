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
//  COPPA.h
//
//  Created by Mahram Z. Foadi on 2016-06-03.
//  Copyright © 2016 just10. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface COPPA : NSObject

+ (bool) ageMeetsCOPPARequirementsWithSeconds: (long) secondsFromEpoch;
+ (bool) ageMeetsCOPPARequirementsWithDate: (NSDate *) birthdate;
+ (bool) ageMeetsCOPPARequirementsWithYYYYMMdd: (NSString *) birthdate;

@end
