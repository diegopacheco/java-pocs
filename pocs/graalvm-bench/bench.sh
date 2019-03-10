#!/bin/bash

echo "Java JVM Bench"
time java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt

echo "GraalVM - Runtime"
time $GRAALVM_HOME/bin/java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt

echo "GraalVM - Native"
time build/topten-native /tmp/bench.file.txt