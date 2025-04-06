#!/bin/bash

# Create a user
curl -i -X POST -H "Content-Type: application/json" \
  -d '{"name":"Alice"}' http://localhost:8080/api/users

# Get all users
curl -i http://localhost:8080/api/users

# Update a user
curl -i -X PUT -H "Content-Type: application/json" \
  -d '{"name":"Alice Updated"}' http://localhost:8080/api/users/1

# Delete a user
curl -i -X DELETE http://localhost:8080/api/users/1