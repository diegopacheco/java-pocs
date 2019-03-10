#!/bin/bash

echo "Gradle build. Building Native Image."
./gradlew clean build
$GRAALVM_HOME/bin/native-image -jar build/libs/graalvm-bench.jar -H:Name=build/topten-native --enable-all-security-services