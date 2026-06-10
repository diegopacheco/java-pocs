#!/usr/bin/env bash
set -uo pipefail

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$DIR"

restore() {
    perl -i -pe 's{<version>2.0.0</version>}{<version>1.0.0</version>}' pom.xml
    cp versions/Calculator.v1.java src/main/java/com/example/Calculator.java
}
trap restore EXIT

echo "==> Step 1: build and install the compatible baseline 1.0.0 (revapi skipped)"
cp versions/Calculator.v1.java src/main/java/com/example/Calculator.java
mvn -q -Drevapi.skip=true clean install || { echo "baseline install failed"; exit 1; }

echo "==> Step 2: introduce a breaking change in the source and bump to 2.0.0"
cp versions/Calculator.v2.java src/main/java/com/example/Calculator.java
perl -i -pe 's{<version>1.0.0</version>}{<version>2.0.0</version>}' pom.xml

echo "==> Step 3: run 'mvn verify' so revapi compares 2.0.0 against 1.0.0"
OUT="$(mvn clean verify 2>&1)"
CODE=$?

echo
echo "----- revapi detected API differences -----"
echo "$OUT" | grep -E '^\[ERROR\] java\.' | sed 's/^\[ERROR\] //'
echo "-------------------------------------------"
echo

if [ $CODE -ne 0 ] && echo "$OUT" | grep -q 'java.method.removed'; then
    echo "RESULT: PASS - revapi caught the breaking change and failed the build."
    exit 0
fi

echo "RESULT: FAIL - revapi did not flag the breaking change."
echo "$OUT" | tail -30
exit 1
