#/bin/bash

/usr/bin/time -f "\nHC return in [%e seconds]" curl -i http://localhost:8080/actuator/health

curl -s http://localhost:8080/actuator/health | jq .