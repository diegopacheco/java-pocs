#!/bin/bash

curl -s -X POST http://localhost:8080/api/votes/Option%20A | jq .
