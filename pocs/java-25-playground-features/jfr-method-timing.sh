#!/bin/bash

APP_CLASS="com.github.diegopacheco.java25.features.FlexibleConstructorBodies"
JAR_FILE="target/java-25-helloworld-1.0-SNAPSHOT.jar"

echo "=== JFR Method Timing & Tracing ==="

echo "Method Timing - measuring constructor performance:"
java -XX:StartFlightRecording=method-timing=com.github.diegopacheco.java25.features.FlexibleConstructorBodies::Employee,filename=timing.jfr -cp $JAR_FILE $APP_CLASS
jfr view method-timing timing.jfr

echo "Method Tracing - tracking all constructors:"
java -XX:StartFlightRecording=method-trace=::<init>,filename=trace.jfr -cp $JAR_FILE $APP_CLASS
jfr view --cell-height 3 method-trace trace.jfr

echo "Combined Timing & Tracing - all methods in target class:"
java -XX:StartFlightRecording=method-timing=com.github.diegopacheco.java25.features.FlexibleConstructorBodies,method-trace=com.github.diegopacheco.java25.features.FlexibleConstructorBodies::main,filename=combined.jfr -cp $JAR_FILE $APP_CLASS
jfr view method-timing combined.jfr
jfr view method-trace combined.jfr

echo "JFR files created:"
ls -la *.jfr
