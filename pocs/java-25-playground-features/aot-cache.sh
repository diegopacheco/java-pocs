#!/bin/bash

APP_CLASS="com.github.diegopacheco.java25.features.FlexibleConstructorBodies"
AOT_CACHE="app.aot"
AOT_CONFIG="app.aotconf"

echo "=== JEP 514: AOT Command-Line Ergonomics Demo ==="
echo

echo "Before JEP 514 (2-step process):"
echo "Step 1: Record training run"
echo "java -XX:AOTMode=record -XX:AOTConfiguration=$AOT_CONFIG -cp target/classes $APP_CLASS"
java -XX:AOTMode=record -XX:AOTConfiguration=$AOT_CONFIG -cp target/classes $APP_CLASS
echo

echo "Step 2: Create AOT cache"
echo "java -XX:AOTMode=create -XX:AOTConfiguration=$AOT_CONFIG -XX:AOTCache=$AOT_CACHE"
java -XX:AOTMode=create -XX:AOTConfiguration=$AOT_CONFIG -XX:AOTCache=$AOT_CACHE
echo

echo "Clean up temporary config file:"
rm -f $AOT_CONFIG
echo "Removed $AOT_CONFIG"
echo

echo "After JEP 514 (1-step process):"
echo "java -XX:AOTCacheOutput=${AOT_CACHE}.new -cp target/classes $APP_CLASS"
java -XX:AOTCacheOutput=${AOT_CACHE}.new -cp target/classes $APP_CLASS
echo

echo "Production run with AOT cache:"
echo "java -XX:AOTCache=$AOT_CACHE -cp target/classes $APP_CLASS"
java -XX:AOTCache=$AOT_CACHE -cp target/classes $APP_CLASS
echo

echo "AOT caches created:"
ls -la *.aot 2>/dev/null || echo "No .aot files found"
