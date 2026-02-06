#!/bin/bash
read -p "Enter product name: " name
read -p "Enter product description: " description
read -p "Enter product price: " price
curl -s -X POST -H "Content-Type: application/json" \
  -d "{\"name\":\"$name\",\"description\":\"$description\",\"price\":$price}" \
  http://localhost:8081/product-create | python3 -m json.tool
