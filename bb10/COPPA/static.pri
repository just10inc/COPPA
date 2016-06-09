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

LIBTARGET = COPPA

profile {
    LIBTARGETDIR_PROFILE = -p
}
CONFIG(debug, debug|release) {
    LIBTARGETDIR_DEBUG = -g
}
device {
    LIBTARGETDIR = arm$${LIBTARGETDIR_PROFILE}/a.le-v7$${LIBTARGETDIR_DEBUG}
}
simulator {
    LIBTARGETDIR = x86$${LIBTARGETDIR_PROFILE}/a$${LIBTARGETDIR_DEBUG}
}

BASEDIR      = $${PWD}
INCLUDEPATH *= $$quote($${BASEDIR}/include)
DEPENDPATH  *= $$quote($${BASEDIR}/include)
LIBS        += -L$${BASEDIR}/$${LIBTARGETDIR} -l$${LIBTARGET}
