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

QMAKE_TARGET  = COPPA
LUPDATE       = $(QNX_HOST)/usr/bin/lupdate
LRELEASE      = $(QNX_HOST)/usr/bin/lrelease

update: ../$(QMAKE_TARGET).pro FORCE
	$(LUPDATE) $(QMAKE_TARGET).pro

release: ../$(QMAKE_TARGET).pro $(QMAKE_TARGET).ts
	@rm -rf qm
	mkdir -p qm
	$(LRELEASE) $(QMAKE_TARGET).pro
	mv *.qm qm/
	
	cd qm && rcc -project -o ../COPPA_translations.qrc
	mv COPPA_translations.qrc qm/

FORCE:
