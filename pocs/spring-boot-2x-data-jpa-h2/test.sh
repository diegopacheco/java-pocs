#!/bin/bash

printf "Creating a book...\n"
curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data '{"author": "Isac Azimov", "title": "Foundation"}' "http://localhost:8080/book"

printf "\n\nGetting a book by title...\n"
curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X GET "http://localhost:8080/book/Foundation"

printf "\n\nGetting all books...\n"
curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X GET "http://localhost:8080/book/"

printf "\n\nDeleting a book by id...\n"
curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X DELETE "http://localhost:8080/book/1"

echo "\n\nFIN."