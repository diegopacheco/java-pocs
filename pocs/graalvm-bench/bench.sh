#!/bin/bash

javac src/main/java/TopTen.java

echo "Java JVM"
time java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt

echo "GraalVM"
time $GRAALVM_HOME/bin/java -jar build/libs/graalvm-bench.jar /tmp/bench.file.txt
