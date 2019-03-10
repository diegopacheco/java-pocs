#!/bin/bash

echo "Gradle build. Building Native Image."
./gradlew clean build
./gradlew nativeImage

echo "Java JVM Bench"
time java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt

echo "GraalVM - Runtime"
time $GRAALVM_HOME/bin/java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt

echo "GraalVM - Native"
time build/graal/topten-native