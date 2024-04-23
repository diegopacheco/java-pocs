#!/bin/bash

echo "This are the input messages from kafka topic: [inputTopic] \n"

HERE=$(pwd)
KAFKA_HOME=/home/diego/bin/kafka_2.13-3.6.2/
cd $KAFKA_HOME
bin/kafka-console-consumer.sh --topic inputTopic --from-beginning --bootstrap-server localhost:29092
cd $HERE
