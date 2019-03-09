#!/bin/bash 

base64 /dev/urandom | head -c 100000000 > /tmp/bench.file.txt
