#!/bin/bash

./mvnw clean compile assembly:single
java -javaagent:agent/target/agent-1.0-SNAPSHOT-jar-with-dependencies.jar -jar \
  app/target/app-1.0-SNAPSHOT-jar-with-dependencies.jar 
