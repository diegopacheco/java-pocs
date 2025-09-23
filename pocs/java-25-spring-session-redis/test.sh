#!/bin/bash

echo "Testing Spring Session functionality..."

echo "Creating session with key=username, value=john"
curl -X POST "http://localhost:8080/session?key=username&value=john" -c cookies.txt

echo ""
echo "Getting session value for key=username"
curl -X GET "http://localhost:8080/session?key=username" -b cookies.txt

echo ""
echo "Creating another session with key=role, value=admin"
curl -X POST "http://localhost:8080/session?key=role&value=admin" -b cookies.txt

echo ""
echo "Getting session value for key=role"
curl -X GET "http://localhost:8080/session?key=role" -b cookies.txt

echo ""
echo "Listing all active sessions in Redis:"
curl -X GET "http://localhost:8080/sessions"

echo ""
echo "Cleaning up cookies file"
rm -f cookies.txt