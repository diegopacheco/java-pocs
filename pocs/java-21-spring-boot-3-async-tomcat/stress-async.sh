#!/bin/bash

#wrk -t500 -c500 -d1m -R10000 http://localhost:8080/async-task

ab -n 60000 -c 1000 http://localhost:8080/async-task

#
#DURATION=60
#END=$((SECONDS+DURATION))
#
#while [ $SECONDS -lt $END ]; do
#  ab -n 1000 -c 1000 http://localhost:8080/async-task &
#  sleep 1
#done
#
#wait