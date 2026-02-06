#!/bin/bash
response=$(curl -s -w "\n%{http_code}" http://localhost:8081/products)
http_code=$(echo "$response" | tail -n1)
body=$(echo "$response" | sed '$d')
if [ -z "$body" ] || [ "$http_code" = "000" ]; then
  echo "Error: App is not running. Start it with ./run-non-prod.sh or ./run-prod.sh"
  exit 1
fi
echo "$body" | python3 -m json.tool
