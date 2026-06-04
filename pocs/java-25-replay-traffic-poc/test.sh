#!/bin/bash
set -e
API=http://localhost:8001

echo "== health =="
curl -s $API/api/health | jq .

echo "== generate 20 PUT =="
curl -s -X POST $API/api/generate -H 'Content-Type: application/json' -d '{"method":"PUT","count":20}' | jq .

echo "== generate 30 GET =="
curl -s -X POST $API/api/generate -H 'Content-Type: application/json' -d '{"method":"GET","count":30}' | jq .

echo "== generate 10 DELETE =="
curl -s -X POST $API/api/generate -H 'Content-Type: application/json' -d '{"method":"DELETE","count":10}' | jq .

echo "== stats =="
curl -s $API/api/stats | jq .

echo "== captured GET entries =="
curl -s "$API/api/log?method=GET" | jq '{count: .count, first: .entries[0]}'

echo "== replay (GET only, writes skipped) =="
curl -s -X POST $API/api/replay | jq .
