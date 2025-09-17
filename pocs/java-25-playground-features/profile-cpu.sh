#!/bin/bash

APP_CLASS="$1"
PROFILE_TIME="${2:-60s}"
OUTPUT_FILE="${3:-cpu-profile.jfr}"

if [ -z "$APP_CLASS" ]; then
    echo "Usage: $0 <MainClass> [duration] [output-file]"
    echo "Example: $0 com.example.MyApp 2m profile.jfr"
    exit 1
fi

if [[ "$OSTYPE" == "linux-gnu"* ]]; then
    JFR_OPTIONS="jdk.CPUTimeSample#enabled=true,jdk.CPUTimeSample#throttle=10ms"
    echo "Using CPU-time profiling (Linux)"
else
    JFR_OPTIONS="jdk.ExecutionSample#enabled=true,jdk.ExecutionSample#period=10ms"
    echo "Using execution sampling (CPU-time profiling not supported on this platform)"
fi

if [[ "$APP_CLASS" == *"VectorAPI"* ]]; then
    MODULE_ARGS="--add-modules jdk.incubator.vector"
else
    MODULE_ARGS=""
fi

java $MODULE_ARGS -XX:StartFlightRecording=$JFR_OPTIONS,duration=$PROFILE_TIME,filename=$OUTPUT_FILE -cp target/classes $APP_CLASS

echo "Profile saved to: $OUTPUT_FILE"
if [[ "$OSTYPE" == "linux-gnu"* ]]; then
    echo "View with: jfr view cpu-time-hot-methods $OUTPUT_FILE"
else
    echo "View with: jfr view hot-methods $OUTPUT_FILE"
fi
