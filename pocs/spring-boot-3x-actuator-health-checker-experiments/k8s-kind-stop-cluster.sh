#!/bin/bash

docker ps

docker stop $(docker ps -q --filter "name=kind")

docker ps