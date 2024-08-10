#!/bin/bash

curl -i -X POST \
 -H "Content-Type: application/json" \
 -H "Accept: application/json" \
 "http://localhost:8080/actuator/shutdown"