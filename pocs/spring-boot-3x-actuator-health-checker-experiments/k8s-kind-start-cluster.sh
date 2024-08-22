#!/bin/bash

docker ps

docker start $(docker ps -a -q --filter "name=kind")

docker ps

sleep 6

kubectl get all