#!/usr/bin/env bash

if [ ! -e "COPPA.xcodeproj" ]; then
	echo "XCode project not found. Are you in the right directory?"
	exit -1
fi

VERSION=$1

if [ -z "$VERSION" ]; then
	echo "No version specified"
	VERSION="dev"
fi

RELEASE_DIR="releases/$VERSION"

if [ -e "$RELEASE_DIR" ]; then
	rm -rf $RELEASE_DIR
fi

mkdir -p $RELEASE_DIR

xcodebuild -sdk iphoneos -configuration Release clean build
xcodebuild -sdk iphonesimulator -configuration Release clean build

lipo -create -output $RELEASE_DIR/libCOPPA.a build/Release-iphoneos/libCOPPA.a build/Release-iphonesimulator/libCOPPA.a

mkdir -p $RELEASE_DIR/include

cp -a COPPA/*.h $RELEASE_DIR/include/

pushd $RELEASE_DIR

#https://s3-us-west-2.amazonaws.com/coppa-lib/releases/j10-coppa-1.1.0-ios.zip

zip -vrm9o j10-coppa-$VERSION-ios.zip include *.a

popd