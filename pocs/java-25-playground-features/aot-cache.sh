#!/bin/bash

APP_CLASS="com.github.diegopacheco.java25.features.FlexibleConstructorBodies"
AOT_CACHE="app.aot"
AOT_CONFIG="app.aotconf"
JAR_FILE="target/java-25-helloworld-1.0-SNAPSHOT.jar"

echo "=== JEP 514: AOT Command-Line Ergonomics Demo ==="
echo

if [ ! -f "$JAR_FILE" ]; then
    echo "Building JAR file first..."
    mvn -q package -DskipTests
    echo
fi

echo "Before JEP 514 (2-step process):"
echo "Step 1: Record training run"
echo "java -XX:AOTMode=record -XX:AOTConfiguration=$AOT_CONFIG -cp $JAR_FILE $APP_CLASS"
java -XX:AOTMode=record -XX:AOTConfiguration=$AOT_CONFIG -cp $JAR_FILE $APP_CLASS
echo

if [ -f "$AOT_CONFIG" ]; then
    echo "Step 2: Create AOT cache"
    echo "java -XX:AOTMode=create -XX:AOTConfiguration=$AOT_CONFIG -XX:AOTCache=$AOT_CACHE"
    java -XX:AOTMode=create -XX:AOTConfiguration=$AOT_CONFIG -XX:AOTCache=$AOT_CACHE
    echo

    echo "Clean up temporary config file:"
    rm -f $AOT_CONFIG
    echo "Removed $AOT_CONFIG"
else
    echo "AOT configuration file not created - skipping cache creation"
fi
echo

echo "After JEP 514 (1-step process):"
echo "java -XX:AOTCacheOutput=${AOT_CACHE}.new -cp $JAR_FILE $APP_CLASS"
java -XX:AOTCacheOutput=${AOT_CACHE}.new -cp $JAR_FILE $APP_CLASS
echo

if [ -f "$AOT_CACHE" ]; then
    echo "Production run with AOT cache:"
    echo "java -XX:AOTCache=$AOT_CACHE -cp $JAR_FILE $APP_CLASS"
    java -XX:AOTCache=$AOT_CACHE -cp $JAR_FILE $APP_CLASS
    echo
fi

echo "AOT cache status:"
ls -la *.aot 2>/dev/null || echo "Note: AOT may not be fully supported on this platform/configuration"
