#!/bin/bash

LOG_CONFIG_FILE=./config/logback-spring.xml
PROFILE=${1:-local}

echo "using log config file: $LOG_CONFIG_FILE"
echo "Using Spring profile: $PROFILE"

./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dlogging.config=$LOG_CONFIG_FILE" -Dspring-boot.run.profiles=$PROFILE