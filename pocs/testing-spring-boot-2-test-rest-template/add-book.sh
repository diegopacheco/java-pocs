#!/bin/bash

curl -d '{"name":"Principles", "author":"Ray Dalio"}' -H "Content-Type: application/json" -X POST http://localhost:8080/book 
