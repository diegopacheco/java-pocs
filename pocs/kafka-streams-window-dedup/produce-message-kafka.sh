#!/bin/bash

HERE=$(pwd)
KAFKA_HOME=/home/diego/bin/kafka_2.13-3.6.2/
cd $KAFKA_HOME 
echo "diego likes kafka" | bin/kafka-console-producer.sh --topic inputTopic --bootstrap-server localhost:29092
cd $HERE 
