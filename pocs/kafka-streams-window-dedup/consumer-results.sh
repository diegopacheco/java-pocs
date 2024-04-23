#!/bin/bash

echo "This are the output messages from kafka topic: [outputTopic] \n"

HERE=$(pwd)
KAFKA_HOME=/home/diego/bin/kafka_2.13-3.6.2/
cd $KAFKA_HOME
bin/kafka-console-consumer.sh --topic outputTopic --from-beginning --bootstrap-server localhost:29092
cd $HERE
