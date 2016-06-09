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

QMAKE = $(QNX_HOST)/usr/bin/qmake
I18N_DIR = ./translations

ifdef NUMBER_OF_PROCESSORS
  MAKEFLAGS += -j${NUMBER_OF_PROCESSORS}
endif

default: Simulator-Debug

.PHONY: FORCE

arm/Makefile: $(QMAKE_TARGET).pro
	@mkdir -p arm
	cd arm && $(QMAKE) -spec blackberry-armv7le-qcc ../$(QMAKE_TARGET).pro CONFIG+=debug_and_release CONFIG+=device

arm-p/Makefile: $(QMAKE_TARGET).pro
	@mkdir -p arm-p
	cd arm-p && $(QMAKE) -spec blackberry-armv7le-qcc ../$(QMAKE_TARGET).pro CONFIG+=debug_and_release CONFIG+=device CONFIG+=profile

x86/Makefile: $(QMAKE_TARGET).pro
	@mkdir -p x86
	cd x86 && $(QMAKE) -spec blackberry-x86-qcc ../$(QMAKE_TARGET).pro CONFIG+=debug_and_release CONFIG+=simulator

Device-Release: arm/Makefile translate FORCE
	$(MAKE) -C ./arm -f Makefile release

Device-Debug: arm/Makefile translate FORCE
	$(MAKE) -C ./arm -f Makefile debug

Device-Profile: arm-p/Makefile translate FORCE
	$(MAKE) -C ./arm-p -f Makefile debug

Simulator-Debug: x86/Makefile translate FORCE
	$(MAKE) -C ./x86 -f Makefile debug

translate: FORCE
	$(MAKE) -C $(I18N_DIR) -f Makefile update
	$(MAKE) -C $(I18N_DIR) -f Makefile release

clean: FORCE
	rm -rf arm arm-p x86 $(I18N_DIR)/qm
