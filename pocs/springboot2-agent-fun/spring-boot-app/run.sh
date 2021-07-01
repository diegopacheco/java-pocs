#!/bin/bash

current_dir=$(pwd)
export MAVEN_OPTS=-javaagent:$current_dir/../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar
./mvnw spring-boot:run