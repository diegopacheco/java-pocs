#!/bin/bash
read -p "Enter product name: " name
read -p "Enter product description: " description
read -p "Enter product price: " price
response=$(curl -s -w "\n%{http_code}" -X POST -H "Content-Type: application/json" \
  -d "{\"name\":\"$name\",\"description\":\"$description\",\"price\":$price}" \
  http://localhost:8081/product-create)
http_code=$(echo "$response" | tail -n1)
body=$(echo "$response" | sed '$d')
if [ -z "$body" ] || [ "$http_code" = "000" ]; then
  echo "Error: App is not running. Start it with ./run-non-prod.sh"
  exit 1
fi
if [ "$http_code" = "404" ]; then
  echo "Error: Endpoint blocked. App is running in prod mode. Use ./run-non-prod.sh"
  exit 1
fi
echo "$body" | python3 -m json.tool
