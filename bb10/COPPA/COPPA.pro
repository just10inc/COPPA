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

APP_NAME = COPPA

CONFIG += qt warn_on

# uncomment for building static library
CONFIG += staticlib

# uncomment for generating separate debug info
# CONFIG += separate_debug_info

include(cascades10_library.pri)

include(config.pri)

# specify a list of .ts files for supported languages
# TRANSLATIONS += $${TARGET}_en_US.ts

# uncomment following line to include translations to binary
# RESOURCES += translations/qm/COPPA_translations.qrc
