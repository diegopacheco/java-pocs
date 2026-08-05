#!/bin/bash
set -e

LIB_DIR="$(dirname "$0")/lib"
REPO="https://github.com/litterat/ltr8-io-tson-java.git"
VERSION="0.1.0-SNAPSHOT"
MODULES="tson tson-compiler tson-schema tson-tree tson-bind tson-annotation tson-regex"

if [ ! -d "$LIB_DIR/ltr8-io-tson-java" ]; then
  mkdir -p "$LIB_DIR"
  git clone --depth 1 "$REPO" "$LIB_DIR/ltr8-io-tson-java"
fi

cd "$LIB_DIR/ltr8-io-tson-java"
./gradlew :tson:jar --console=plain

for m in $MODULES; do
  mvn -q -B install:install-file \
    -Dfile="$m/build/libs/$m-$VERSION.jar" \
    -DgroupId=io.ltr8 \
    -DartifactId="$m" \
    -Dversion="$VERSION" \
    -Dpackaging=jar
  echo "installed io.ltr8:$m:$VERSION"
done
