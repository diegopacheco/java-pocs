#!/bin/bash

echo "Gradle build. Building Native Image."
./gradlew clean build
mkdir build/graal/
$GRAALVM_HOME/bin/native-image -jar build/libs/graalvm-bench.jar -H:Name=build/graal/topten-native --enable-all-security-services
