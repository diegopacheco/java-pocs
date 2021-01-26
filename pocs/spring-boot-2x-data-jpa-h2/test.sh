#!/bin/bash

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data '{"author": "Isac Azimov", "title": "Foundation"}' "http://localhost:8080/book"

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X GET "http://localhost:8080/book/Foundation"

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X GET "http://localhost:8080/book/"

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X DELETE "http://localhost:8080/book/1"