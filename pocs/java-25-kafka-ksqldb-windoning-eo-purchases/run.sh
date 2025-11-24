#!/bin/bash
./start.sh
./stop-app.sh 2>/dev/null
sleep 1
mvn spring-boot:run

