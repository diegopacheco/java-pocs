#!/bin/bash

current_dir=$(pwd)

# option 1 - Before Maven
#export MAVEN_OPTS="-javaagent:$current_dir/../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar -javaagent:$current_dir/../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar"
#./mvnw spring-boot:run

# option 2 - Before Spring Boot App
./mvnw spring-boot:run -Dspring-boot.run.agents="../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar,../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar"

# option 3 - Running with Java
#java -javaagent:../java-agent/target/java-agent-1.0-SNAPSHOT-jar-with-dependencies.jar -jar target/spring-boot-app-1.0-SNAPSHOT.jar