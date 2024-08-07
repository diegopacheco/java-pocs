#!/bin/bash

if [ -z "$1" ]
then
  echo "[Doing Static Agent]"
  ./mvnw clean compile assembly:single
  java -javaagent:agent/target/agent-1.0-SNAPSHOT-jar-with-dependencies.jar \
  -jar app/target/app-1.0-SNAPSHOT-jar-with-dependencies.jar
else
  echo "[Doing Dynamic Load]"
  ./mvnw clean compile assembly:single
  java -classpath "/home/diego/bin/jdk1.8.0_241/lib/tools.jar:app/target/app-1.0-SNAPSHOT-jar-with-dependencies.jar:agent/target/agent-1.0-SNAPSHOT-jar-with-dependencies.jar" \
  com.github.diegopacheco.app.Main "comom.github.diegopacheco.agent.Agent"
fi
