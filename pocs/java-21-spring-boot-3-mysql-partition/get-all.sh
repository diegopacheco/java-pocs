#!/bin/bash

curl -s -X GET http://localhost:8080/api/users | jq .
