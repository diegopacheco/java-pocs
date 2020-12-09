#!/bin/bash

export MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=y"
mvn spring-boot:run 
