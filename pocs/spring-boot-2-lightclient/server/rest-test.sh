#!/bin/bash

echo "GET - Mul(2,3)"
time curl --silent -H "Content-Type: application/json" "http://localhost:8080/mul/2/3/"

echo "POST - Sum(2,3)"
time curl --silent -H "Content-Type: application/json" \
  --request POST \
  --data '{"va":"2","vb":"3"}' \
  "http://localhost:8080/sum/"
