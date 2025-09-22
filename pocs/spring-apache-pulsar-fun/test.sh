#!/bin/bash

echo "Testing Spring Boot Apache Pulsar Integration"

APP_URL="http://localhost:8090"

echo "1. Testing application health..."
curl -s $APP_URL/ || exit 1

echo -e "\n2. Clearing any existing messages..."
curl -s -X DELETE $APP_URL/messages

echo -e "\n3. Sending test message 1..."
curl -s -X POST "$APP_URL/send?message=Hello%20Pulsar%201"

echo -e "\n4. Sending test message 2..."
curl -s -X POST "$APP_URL/send?message=Hello%20Pulsar%202"

echo -e "\n5. Sending test message 3..."
curl -s -X POST "$APP_URL/send?message=Testing%20Message%20Consumer"

echo -e "\n6. Waiting for messages to be consumed..."
sleep 3

echo -e "\n7. Retrieving consumed messages..."
curl -s $APP_URL/messages | jq .

echo -e "\n\nTest completed successfully!"