#!/usr/bin/bash

path=${1:-"actuator/health"}
users=${2:-"500"}

ulimit -n 65000
sudo sysctl -w net.ipv4.ip_local_port_range="1025 65535"
echo 300000 | sudo tee /proc/sys/fs/nr_open
echo 300000 | sudo tee /proc/sys/fs/file-max

./mvnw gatling:test -Dgatling.simulation=GenericSimulation -Dpath=$path -Dusers=$users