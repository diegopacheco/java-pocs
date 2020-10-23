#!/bin/bash

for n in {1..6} 
do
 echo "keys *" | redis-cli -p 3000$n
done
