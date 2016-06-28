#!/usr/bin/env bash

# Copyright 2016 Just10 Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

VERSION_MAJOR=1
VERSION_MINOR=1
VERSION_PATCH=1

UGLIFIER=$(which uglifyjs)

if [ -z $UGLIFIER ]; then
    echo "uglify-js not found. Install it by running 'npm install -g uglify-js'"
    exit -1
fi

echo "Using uglifier $UGLIFIER"

OUTPUT="j10-coppa-$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH.min.js"

if [ -e "$OUTPUT" ]; then
    echo "Deleting $OUTPUT"
  rm -vf $OUTPUT
fi

echo "Minifying into $OUTPUT..."

$UGLIFIER src/coppa.js -o $OUTPUT
