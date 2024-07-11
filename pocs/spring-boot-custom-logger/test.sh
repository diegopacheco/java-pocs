#!/bin/bash 

curl -H "X-FORWARDED-FOR: 10.99.0.100" -H "Content-Type: application/json" -H "CUSTOM-HEADER-Z: 42" http://127.0.0.1:8080/actuator/health
