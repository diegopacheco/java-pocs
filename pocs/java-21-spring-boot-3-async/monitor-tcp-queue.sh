#!/bin/bash

sudo ss -tulnp | grep $(sudo lsof -i :8080 | awk 'NR==2 {print $2}') | awk '{print "Netty - recv-Q: "$3", send-q: "$4}'

