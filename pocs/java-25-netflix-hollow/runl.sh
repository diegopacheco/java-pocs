#!/usr/bin/env bash
set -euo pipefail
mvn -DskipTests compile
CP=$(mvn -DskipTests -Dmdep.outputAbsoluteArtifactFilename=true -Dmdep.pathSeparator=: -DincludeScope=runtime dependency:build-classpath | awk '/Dependencies classpath:/{getline;print;exit}')
java -cp target/classes:$CP com.diegopacheco.hollow.App
