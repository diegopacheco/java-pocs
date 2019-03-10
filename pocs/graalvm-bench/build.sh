#!/bin/bash

echo "Gradle build. Building Native Image."
./gradlew clean build
./gradlew nativeImage