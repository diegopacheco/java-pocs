#!/bin/bash

#wrk -t500 -c500 -d1m -R10000 http://localhost:8080/stress-benchmark-01

ab -n 60000 -c 1000 http://localhost:8080/stress-benchmark-01

#
#DURATION=60
#END=$((SECONDS+DURATION))
#
#while [ $SECONDS -lt $END ]; do
#  ab -n 1000 -c 1000 http://localhost:8080/stress-benchmark-01 &
#  sleep 1
#done
#
#wait