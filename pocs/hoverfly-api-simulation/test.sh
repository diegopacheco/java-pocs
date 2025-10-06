#!/bin/bash

echo "Testing Hoverfly API Simulation..."
echo ""

echo "Test 1: GET /users/1 via proxy"
curl -x http://localhost:8500 http://api.test.com/users/1
echo ""
echo ""

echo "Test 2: GET /users/2 via proxy"
curl -x http://localhost:8500 http://api.test.com/users/2
echo ""
echo ""

echo "Test 3: POST /users via proxy"
curl -x http://localhost:8500 -X POST http://api.test.com/users -H "Content-Type: application/json" -d '{"name":"Test User"}'
echo ""
echo ""

echo "Test 4: Check Hoverfly Admin API"
curl -s http://localhost:8888/api/v2/simulation | head -20
echo ""
echo ""

echo "All tests completed!"
