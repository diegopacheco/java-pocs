#!/bin/bash

# Build the solution
mvn clean install

# Inject Exceptions (100% working)
java -javaagent:byte-monkey.jar=mode:fault,rate:0.9,filter:.* -jar target/byte-monkey-fun-1.0-SNAPSHOT.jar

# Inject Latency 3s latency (100% working)
#java -javaagent:byte-monkey.jar=mode:latency,latency:3000,rate:0.9,filter:.* -jar target/byte-monkey-fun-1.0-SNAPSHOT.jar

# Inject Nulls (100% working)
#java -javaagent:byte-monkey.jar=mode:nullify,rate:0.9,filter:.* -jar target/byte-monkey-fun-1.0-SNAPSHOT.jar

