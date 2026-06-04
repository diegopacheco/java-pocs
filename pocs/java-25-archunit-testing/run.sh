#!/bin/bash
./start.sh
trap './stop.sh' EXIT
./gradlew bootRun
