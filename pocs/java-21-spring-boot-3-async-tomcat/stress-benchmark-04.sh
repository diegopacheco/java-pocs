#!/bin/bash

#wrk -t500 -c500 -d1m -R10000 http://localhost:8080/stress-benchmark-04

ab -n 100000 -c 5000 http://localhost:8080/stress-benchmark-04

#
#DURATION=60
#END=$((SECONDS+DURATION))
#
#while [ $SECONDS -lt $END ]; do
#  ab -n 1000 -c 1000 http://localhost:8080/stress-benchmark-04 &
#  sleep 1
#done
#
#wait