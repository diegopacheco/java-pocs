#!/bin/bash
curl -s http://localhost:8081/products | python3 -m json.tool
