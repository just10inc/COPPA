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

LIBS           += -lbbcascades
QT             += declarative
QT             -= gui

QMAKE_CFLAGS   += -Wno-psabi
QMAKE_CXXFLAGS += -Wno-psabi

TEMPLATE = lib

staticlib {
    QNX_VARIANT_DIR = a
} else {
    QNX_VARIANT_DIR = so
}

device {
    QNX_VARIANT_DIR = $${QNX_VARIANT_DIR}.le-v7
}

simulator {
}

CONFIG(debug, debug|release) {
    QNX_VARIANT_DIR  = $${QNX_VARIANT_DIR}-g
    DEFINES         += QT_DECLARATIVE_DEBUG
}

CONFIG(release, debug|release) {
    QMAKE_CFLAGS   += -fstack-protector-strong -mthumb -Os
    QMAKE_CXXFLAGS += -fstack-protector-strong -mthumb -Os
    QMAKE_LFLAGS   += -Wl,-z,relro
    DEFINES        += _FORTIFY_SOURCE=2
}

DESTDIR = $${QNX_VARIANT_DIR}

profile {
    QMAKE_CXXFLAGS += -g -finstrument-functions
    LIBS           += -lprofilingS
}

QMAKE_CFLAGS   += -fvisibility=hidden
QMAKE_CXXFLAGS += -fvisibility=hidden

DEFINES += COPPA_LIBRARY
staticlib {
    DEFINES += COPPA_STATIC_LINK
}

OBJECTS_DIR = $${DESTDIR}/obj
MOC_DIR     = $${DESTDIR}/moc
RCC_DIR     = $${DESTDIR}/rcc
UI_DIR      = $${DESTDIR}/ui
