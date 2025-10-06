#!/bin/bash

echo "Waiting for Hoverfly to be ready..."
ATTEMPTS=0
MAX_ATTEMPTS=30
while [ $ATTEMPTS -lt $MAX_ATTEMPTS ]; do
    if curl -4 -s http://127.0.0.1:8888/api/v2/hoverfly > /dev/null 2>&1; then
        echo "Hoverfly is ready!"
        break
    fi
    ATTEMPTS=$((ATTEMPTS + 1))
    sleep 1
done

if [ $ATTEMPTS -eq $MAX_ATTEMPTS ]; then
    echo "Timeout waiting for Hoverfly"
    exit 1
fi

echo ""
echo "Testing Hoverfly API Simulation..."
echo ""

echo "Test 1: GET /users/1 via proxy"
curl -4 -x http://127.0.0.1:8500 http://api.test.com/users/1
echo ""
echo ""

echo "Test 2: GET /users/2 via proxy"
curl -4 -x http://127.0.0.1:8500 http://api.test.com/users/2
echo ""
echo ""

echo "Test 3: POST /users via proxy"
curl -4 -x http://127.0.0.1:8500 -X POST http://api.test.com/users -H "Content-Type: application/json" -d '{"name":"Test User"}'
echo ""
echo ""

echo "Test 4: Check Hoverfly Admin API (first 10 lines)"
curl -4 -s http://127.0.0.1:8888/api/v2/simulation | head -10
echo ""
echo ""

echo "All tests completed!"
