#!/bin/bash

current_dir=$(pwd)

# option 1 - Before Maven
#export MAVEN_OPTS="-javaagent:$current_dir/../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar -javaagent:$current_dir/../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar"
#./mvnw spring-boot:run

# option 2 - Before Spring Boot App
./mvnw spring-boot:run -Dspring-boot.run.agents="../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar"