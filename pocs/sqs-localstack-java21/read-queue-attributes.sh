#!/bin/bash 

awslocal sqs get-queue-attributes --queue-url "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/test-queue" --attribute-names All
