#!/bin/bash

name=$(cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w 20 | head -n 1)
phone=$(shuf -i 10000-99999 -n 1)

echo "Enrolling a new user..."

payload='{
    "id": "0",
    "name": "John Doe",
    "email": "john.doe'"$name"'@example.com",
    "phone": "555-123-'"$phone"'"
}'

echo ">>> Request:"
echo "$payload" | jq .

echo "<<< Response:"
curl -s -X POST \
  http://localhost:8080/api/users/enroll \
  -H 'Content-Type: application/json' \
  -d "$payload" | jq .